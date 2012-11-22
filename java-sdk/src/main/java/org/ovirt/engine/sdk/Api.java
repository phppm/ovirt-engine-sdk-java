//
// Copyright (c) 2012 Red Hat, Inc.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//           http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
//

package org.ovirt.engine.sdk;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import org.apache.http.client.ClientProtocolException;
import org.ovirt.engine.sdk.web.ConnectionsPool;
import org.ovirt.engine.sdk.web.ConnectionsPoolBuilder;
import org.ovirt.engine.sdk.web.HttpProxy;
import org.ovirt.engine.sdk.web.HttpProxyBroker;
import org.ovirt.engine.sdk.web.HttpProxyBuilder;
import org.ovirt.engine.sdk.decorators.*;
import org.ovirt.engine.sdk.entities.API;
import org.ovirt.engine.sdk.exceptions.ServerException;
import org.ovirt.engine.sdk.exceptions.UnsecuredConnectionAttemptError;
import org.ovirt.engine.sdk.utils.SerializationHelper;

/**
 * oVirt virtualization Java SDK
 */
public class Api {

    private HttpProxyBroker proxy = null;
    private API entryPoint = null;

    private Networks networks;
    private Tags tags;
    private Users users;
    private Templates templates;
    private Events events;
    private Domains domains;
    private Disks disks;
    private Clusters clusters;
    private DataCenters dataCenters;
    private Roles roles;
    private Hosts hosts;
    private VMs vMs;
    private VmPools vmPools;
    private StorageDomains storageDomains;
    private Groups groups;


    /**
     * @param url
     *            oVirt api url
     * @param username
     *            oVirt api username
     * @param password
     *            oVirt api password
     * @throws ClientProtocolException
     * @throws ServerException
     *             oVirt api error
     * @throws IOException
     * @throws UnsecuredConnectionAttemptError
     * @throws JAXBException
     */
    public Api(String url, String username, String password) throws ClientProtocolException, ServerException,
            IOException, UnsecuredConnectionAttemptError, JAXBException {

        // FIXME: do not throw ClientProtocolException/JAXBException

        ConnectionsPool pool = new ConnectionsPoolBuilder(url, username, password).build();
        HttpProxy httpProxy = new HttpProxyBuilder(pool).build();
        this.proxy = new HttpProxyBroker(httpProxy);
        this.initResources();
    }

    /**
     * @param url
     *            oVirt api url
     * @param username
     *            oVirt api username
     * @param password
     *            oVirt api password
     * @param insecure
     *            do not throw error when accessing SSL sites without certificate
     * @throws ClientProtocolException
     * @throws ServerException
     *             oVirt api error
     * @throws UnsecuredConnectionAttemptError
     * @throws IOException
     * @throws JAXBException
     */
    public Api(String url, String username, String password, boolean insecure) throws ClientProtocolException,
            ServerException, UnsecuredConnectionAttemptError, IOException, JAXBException {

        // FIXME: do not throw ClientProtocolException/JAXBException

        ConnectionsPool pool = new ConnectionsPoolBuilder(url, username, password)
                                 .build();
        HttpProxy httpProxy = new HttpProxyBuilder(pool)
                                 .insecure(insecure)
                                 .build();
        this.proxy = new HttpProxyBroker(httpProxy);
        initResources();
    }

    /**
     * @param url
     *            oVirt api url
     * @param username
     *            oVirt api username
     * @param password
     *            oVirt api password
     * @param ca_file
     *            CA certificate to validate the server identity
     * @param filter
     *            enables filtering based on user's permissions
     * @throws ClientProtocolException
     * @throws ServerException
     *             oVirt api error
     * @throws UnsecuredConnectionAttemptError
     * @throws IOException
     * @throws JAXBException
     */
    public Api(String url, String username, String password, String ca_file, boolean filter)
            throws ClientProtocolException, ServerException, UnsecuredConnectionAttemptError, IOException,
            JAXBException {

        // FIXME: do not throw ClientProtocolException/JAXBException

        ConnectionsPool pool = new ConnectionsPoolBuilder(url, username, password)
                                   .ca_file(ca_file)
                                   .build();
        HttpProxy httpProxy = new HttpProxyBuilder(pool)
                                   .filter(filter)
                                   .build();
        this.proxy = new HttpProxyBroker(httpProxy);
        initResources();
    }

    /**
     * @param url
     *            oVirt api url
     * @param username
     *            oVirt api username
     * @param password
     *            oVirt api password
     * @param key_file
     *            user key file to validate client identity
     * @param cert_file
     *            user certificate file to validate client identity
     * @param ca_file
     *            CA certificate to validate the server identity
     * @param port
     *            oVirt api port
     * @param timeout
     *            request timeout
     * @param persistentAuth
     *            disable persistent authetication (will be used auth. per request)
     * @param insecure
     *            do not throw error when accessing SSL sites without certificate
     * @param filter
     *            enables filtering based on user's permissions
     * @param debug
     *            enables debug mode
     * @throws ClientProtocolException
     * @throws ServerException
     *             oVirt api error
     * @throws UnsecuredConnectionAttemptError
     * @throws IOException
     * @throws JAXBException
     */
    public Api(String url, String username, String password, String key_file,
              String cert_file, String ca_file, Integer port, Integer timeout,
              Boolean persistentAuth, Boolean insecure, Boolean filter, Boolean debug) throws ClientProtocolException,
            ServerException, UnsecuredConnectionAttemptError, IOException, JAXBException {

        // FIXME: do not throw ClientProtocolException/JAXBException

        ConnectionsPool pool = new ConnectionsPoolBuilder(url, username, password)
                                .key_file(key_file)
                                .cert_file(cert_file)
                                .ca_file(ca_file)
                                .port(port)
                                .timeout(timeout)
                                .build();
        HttpProxy httpProxy = new HttpProxyBuilder(pool)
                                .persistentAuth(persistentAuth)
                                .insecure(insecure)
                                .filter(filter)
                                .debug(debug)
                                .build();
        this.proxy = new HttpProxyBroker(httpProxy);
        initResources();
    }

    private API getEntryPoint() throws ClientProtocolException, ServerException, IOException,
            UnsecuredConnectionAttemptError, JAXBException {
        String entryPointXML = this.proxy.get(this.proxy.getRoot());
        if (entryPointXML != null && !entryPointXML.equals("")) {
            return SerializationHelper.unmarshall(API.class, entryPointXML);
        }
        throw new UnsecuredConnectionAttemptError();
    }

    private void initResources() throws ClientProtocolException, ServerException, UnsecuredConnectionAttemptError,
            IOException, JAXBException {
        this.entryPoint = getEntryPoint();
    }

    /**
     * Enable/Disable client permissions based filtering (default is False)
     * 
     * @param filter
     */
    public void setFilter(boolean filter) {
        this.proxy.setFilter(filter);
    }

    /**
     * Enable/Disable debug mode (default is False)
     * 
     * @param debug
     */
    public void setDebug(boolean debug) {
        this.proxy.setDebug(debug);
    }

    /**
     * Enable/Disable accessing SSL sites without validating host identity (default is False)
     * 
     * @param insecure
     */
    public void setInsecure(boolean insecure) {
        this.proxy.setInsecure(insecure);
    }

    /**
     * Enable/Disable persistent authentication (default is True)
     * 
     * @param persistentAuth
     */
    public void setPersistentAuth(boolean persistentAuth) {
        this.proxy.setPersistentAuth(persistentAuth);
    }

    /**
     * @return persistent authentication flag
     */
    public boolean isPersistentAuth() {
        return this.proxy.isPersistentAuth();
    }

    /**
     * @return Insecure flag
     */
    public boolean isInsecure() {
        return this.proxy.isInsecure();
    }

    /**
     * @return Filter flag
     */
    public boolean isFilter() {
        return this.proxy.isFilter();
    }

    /**
     * @return Debug flag
     */
    public boolean isDebug() {
        return this.proxy.isDebug();
    }

    public synchronized Networks getNetworks() {
        if (this.networks == null) {
            this.networks = new Networks(proxy);
        }
        return networks;
    }

    public synchronized Tags getTags() {
        if (this.tags == null) {
            this.tags = new Tags(proxy);
        }
        return tags;
    }

    public synchronized Users getUsers() {
        if (this.users == null) {
            this.users = new Users(proxy);
        }
        return users;
    }

    public synchronized Templates getTemplates() {
        if (this.templates == null) {
            this.templates = new Templates(proxy);
        }
        return templates;
    }

    public synchronized Events getEvents() {
        if (this.events == null) {
            this.events = new Events(proxy);
        }
        return events;
    }

    public synchronized Domains getDomains() {
        if (this.domains == null) {
            this.domains = new Domains(proxy);
        }
        return domains;
    }

    public synchronized Disks getDisks() {
        if (this.disks == null) {
            this.disks = new Disks(proxy);
        }
        return disks;
    }

    public synchronized Clusters getClusters() {
        if (this.clusters == null) {
            this.clusters = new Clusters(proxy);
        }
        return clusters;
    }

    public synchronized DataCenters getDataCenters() {
        if (this.dataCenters == null) {
            this.dataCenters = new DataCenters(proxy);
        }
        return dataCenters;
    }

    public synchronized Roles getRoles() {
        if (this.roles == null) {
            this.roles = new Roles(proxy);
        }
        return roles;
    }

    public synchronized Hosts getHosts() {
        if (this.hosts == null) {
            this.hosts = new Hosts(proxy);
        }
        return hosts;
    }

    public synchronized VMs getVMs() {
        if (this.vMs == null) {
            this.vMs = new VMs(proxy);
        }
        return vMs;
    }

    public synchronized VmPools getVmPools() {
        if (this.vmPools == null) {
            this.vmPools = new VmPools(proxy);
        }
        return vmPools;
    }

    public synchronized StorageDomains getStorageDomains() {
        if (this.storageDomains == null) {
            this.storageDomains = new StorageDomains(proxy);
        }
        return storageDomains;
    }

    public synchronized Groups getGroups() {
        if (this.groups == null) {
            this.groups = new Groups(proxy);
        }
        return groups;
    }




}
