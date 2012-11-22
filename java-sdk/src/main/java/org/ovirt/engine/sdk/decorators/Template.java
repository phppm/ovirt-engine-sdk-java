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

package org.ovirt.engine.sdk.decorators;

import java.io.IOException;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.ovirt.engine.sdk.entities.Action;
import org.ovirt.engine.sdk.entities.Response;
import org.ovirt.engine.sdk.exceptions.ServerException;
import org.ovirt.engine.sdk.utils.HttpHeaderUtils;
import org.ovirt.engine.sdk.web.HttpProxyBroker;

public class Template extends
        org.ovirt.engine.sdk.entities.Template {

    private HttpProxyBroker proxy;

    private TemplateCdRoms templateCdRoms;
    private TemplateNICs templateNICs;
    private TemplatePermissions templatePermissions;
    private TemplateDisks templateDisks;


    public Template(HttpProxyBroker proxy) {
        this.proxy = proxy;
    }

    private HttpProxyBroker getProxy() {
        return proxy;
    }

    public synchronized TemplateCdRoms getTemplateCdRoms() {
        if (this.templateCdRoms == null) {
            this.templateCdRoms = new TemplateCdRoms(proxy, this);
        }
        return templateCdRoms;
    }

    public synchronized TemplateNICs getTemplateNICs() {
        if (this.templateNICs == null) {
            this.templateNICs = new TemplateNICs(proxy, this);
        }
        return templateNICs;
    }

    public synchronized TemplatePermissions getTemplatePermissions() {
        if (this.templatePermissions == null) {
            this.templatePermissions = new TemplatePermissions(proxy, this);
        }
        return templatePermissions;
    }

    public synchronized TemplateDisks getTemplateDisks() {
        if (this.templateDisks == null) {
            this.templateDisks = new TemplateDisks(proxy, this);
        }
        return templateDisks;
    }



    
}
