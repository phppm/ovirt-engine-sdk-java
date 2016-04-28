package org.ovirt.engine.sdk4.internal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.security.cert.CertificateException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

import org.apache.http.ProtocolException;
import org.apache.http.auth.AuthSchemeProvider;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.config.AuthSchemes;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.config.Lookup;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.DefaultHostnameVerifier;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.auth.SPNegoSchemeFactory;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.BasicHttpClientConnectionManager;
import org.apache.http.ssl.SSLContexts;
import org.ovirt.engine.sdk4.ConnectionBuilder;
import org.ovirt.engine.sdk4.HttpClient;

public class ConnectionBuilder45 extends ConnectionBuilder {

    public ConnectionBuilder45() {
    }

    /**
     * Creates HttpClient
     */
    @Override
    protected HttpClient createHttpClient() throws ProtocolException {
        int port = getPort();
        Lookup<AuthSchemeProvider> authSchemeProvider = null;
        CredentialsProvider credsProvider = new BasicCredentialsProvider();
        AuthScope authScope = new AuthScope(getHost(), port, AuthScope.ANY_REALM, AuthScope.ANY_SCHEME);

        if (user != null && user.length() > 0) {
            credsProvider.setCredentials(
                authScope,
                new UsernamePasswordCredentials(user, password)
            );
        }
        else if (kerberos) {
            authSchemeProvider = RegistryBuilder.<AuthSchemeProvider>create()
                .register(AuthSchemes.SPNEGO, new SPNegoSchemeFactory(true))
                .build();
            credsProvider.setCredentials(
                authScope,
                new Credentials() {
                    @Override
                    public Principal getUserPrincipal() {
                        return null;
                    }

                    @Override
                    public String getPassword() {
                        return null;
                    }
                }
            );
        }

        RequestConfig globalConfig = RequestConfig.custom()
            .setCookieSpec(CookieSpecs.IGNORE_COOKIES)
            .setConnectTimeout(timeout)
            .build();
        HttpClientBuilder clientBuilder = HttpClientBuilder.create()
            .setConnectionManager(new BasicHttpClientConnectionManager(createConnectionSocketFactoryRegistry()))
            .setDefaultRequestConfig(globalConfig)
            .setDefaultCredentialsProvider(credsProvider)
            .setDefaultAuthSchemeRegistry(authSchemeProvider);

        if (!compress) {
            clientBuilder.disableContentCompression();
        }

        return new HttpClient45(clientBuilder.build());
    }

    private Registry createConnectionSocketFactoryRegistry() throws ProtocolException {
        String protocol = getProtocol();
        Registry registry = null;

        // Create SSL/TLS or plain connection:
        if (HTTP_PROTOCOL.equals(protocol)) {
            ConnectionSocketFactory plainsf = PlainConnectionSocketFactory.getSocketFactory();
            registry = RegistryBuilder.<ConnectionSocketFactory>create()
                .register(HTTP_PROTOCOL, plainsf)
                .build();
        }
        else if (HTTPS_PROTOCOL.equals(protocol)) {
            try {
                LayeredConnectionSocketFactory sslsf = null;
                if (this.insecure) {
                    SSLContext sslcontext = SSLContext.getInstance("TLS");
                    sslcontext.init(null, new TrustManager[]{noCaTrustManager}, null);
                    sslsf = new SSLConnectionSocketFactory(sslcontext, NoopHostnameVerifier.INSTANCE);
                }
                else {
                    SSLContext sslContext = SSLContexts.custom()
                        .loadTrustMaterial(
                            new File(trustStoreFile),
                            this.trustStorePassword != null ? this.trustStorePassword.toCharArray() : null
                        )
                        .build();
                    sslsf = new SSLConnectionSocketFactory(sslContext, new DefaultHostnameVerifier());
                }
                registry = RegistryBuilder.<ConnectionSocketFactory>create()
                    .register(HTTPS_PROTOCOL, sslsf)
                    .build();
            }
            catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(NO_TLS_ERROR, e);
            }
            catch (KeyManagementException e) {
                throw new RuntimeException(BAD_KEY_ERROR, e);
            }
            catch (KeyStoreException e) {
                throw new RuntimeException(KEY_STORE_ERROR, e);
            }
            catch (FileNotFoundException e) {
                throw new RuntimeException(KEY_STORE_FILE_NOT_FOUND_ERROR, e);
            }
            catch (CertificateException e) {
                throw new RuntimeException(CERTIFICATE_ERROR, e);
            }
            catch (IOException e) {
                throw new RuntimeException(IO_ERROR, e);
            }

        }
        else {
            throw new ProtocolException(BAD_PROTOCOL_ERROR + protocol);
        }

        return registry;
    }
}