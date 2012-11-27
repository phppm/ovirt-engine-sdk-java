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

// *********************************************************************
// ********************* GENERATED CODE - DO NOT MODIFY ****************
// *********************************************************************

package org.ovirt.engine.sdk.decorators;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.xml.bind.JAXBException;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.ovirt.engine.sdk.common.CollectionDecorator;
import org.ovirt.engine.sdk.exceptions.ServerException;
import org.ovirt.engine.sdk.utils.CollectionUtils;
import org.ovirt.engine.sdk.utils.HttpHeaderUtils;
import org.ovirt.engine.sdk.utils.UrlHelper;
import org.ovirt.engine.sdk.web.HttpProxyBroker;
import org.ovirt.engine.sdk.web.UrlParameterType;
import org.ovirt.engine.sdk.entities.Action;

/**
 * Networks decorator.
 */
@SuppressWarnings("unused")
public class Networks extends
        CollectionDecorator<org.ovirt.engine.sdk.entities.Network, 
                            org.ovirt.engine.sdk.entities.Networks, 
                            Network> {

    /**
     * @param proxy HttpProxyBroker
     */
    public Networks(HttpProxyBroker proxy) {
        super(proxy, "networks");
    }

    /**
     * Lists Network objects.
     *
     * @return
     *     List of Networks
     *
     * @throws ClientProtocolException
     * @throws ServerException
     * @throws IOException
     * @throws JAXBException
     */
    @Override
    public List<Network> list() throws ClientProtocolException,
            ServerException, IOException, JAXBException {
        String url = SLASH + getName();
        return list(url, org.ovirt.engine.sdk.entities.Networks.class, Network.class);
    }

    /**
     * Fetches Network object by id.
     *
     * @return {@link Network }
     *
     * @throws ClientProtocolException
     * @throws ServerException
     * @throws IOException
     * @throws JAXBException
     */
    @Override
    public Network get(UUID id) throws ClientProtocolException,
            ServerException, IOException, JAXBException {
        String url = SLASH + getName() + SLASH + id.toString();
        return getProxy().get(url, org.ovirt.engine.sdk.entities.Network.class, Network.class);
    }

    /**
     * Adds Network object.
     *
     * @param Network
     *
     * network.data_center.id|name
     * network.name
     * network.description
     * network.vlan.id
     * network.ip.address
     * network.ip.gateway
     * network.ip.netmask
     * network.display
     * network.stp
     * network.mtu
     *
     * @return
     *     {@link Network }
     *
     * @throws ClientProtocolException
     * @throws ServerException
     * @throws IOException
     * @throws JAXBException
     */
    public Network add(org.ovirt.engine.sdk.entities.Network network) throws 
            ClientProtocolException, ServerException, IOException, JAXBException {
        String url = SLASH + getName();
        return getProxy().add(url, network, org.ovirt.engine.sdk.entities.Network.class, Network.class);
    }

}

