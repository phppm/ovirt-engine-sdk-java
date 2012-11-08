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

package org.ovirt.engine.sdk.common;

import org.ovirt.engine.sdk.web.HttpProxy;

public abstract class AbstractResourceDecorator<Q> extends AbstractDecorator {

    private HttpProxy proxy;

    public AbstractResourceDecorator(HttpProxy proxy) {
        super();
        this.proxy = proxy;
    }

    public HttpProxy getProxy() {
        return proxy;
    }
}
