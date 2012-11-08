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

package org.ovirt.engine.sdk.utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

import javax.xml.bind.JAXBException;

import org.ovirt.engine.sdk.web.HttpProxy;

public class Mapper {
    private static String[] MAPPING_EXCEPTIONS = new String[] { "links", "actions" };

    @SuppressWarnings("unchecked")
    public static synchronized <F, T> T map(F from, Class<T> to, HttpProxy proxy) {
        T dstobj = null;
        try {
            dstobj = (T) getConstracor(to).newInstance(proxy);
            for (Field f : ArrayUtils.concat(from.getClass().getSuperclass().getDeclaredFields(),
                                             from.getClass().getDeclaredFields())) {
                if (!Arrays.asList(MAPPING_EXCEPTIONS).contains(f.getName())) {
                    Field dstField;
                    try {
                        dstField = dstobj.getClass().getSuperclass().getDeclaredField(f.getName());
                    } catch (NoSuchFieldException e) {
                        dstField = dstobj.getClass().getSuperclass().getSuperclass().getDeclaredField(f.getName());
                    }
                    if (dstField != null) {
                        setFieldContent(dstField.getName(),
                                dstobj,
                                getFieldContent(dstField.getName(), from),
                                dstField.getType());
                    }
                }
            }
        } catch (InstantiationException e) {
            // TODO: log error
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO: log error
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            // TODO: log error
            e.printStackTrace();
        } catch (SecurityException e) {
            // TODO: log error
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO: log error
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            // TODO: log error
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            // TODO: log error
            e.printStackTrace();
        }

        return dstobj;
    }

    private static <T> Object setFieldContent(String name, T to, Object content, Class<?> typ) {
        String getMethodName = "set" + Character.toUpperCase(name.charAt(0)) + name.substring(1);

        Method m;
        try {
            m = to.getClass().getMethod(getMethodName, new Class<?>[] { typ });
            if (m != null) {
                return m.invoke(to, content);
            }
        } catch (SecurityException e1) {
            // TODO: Log error
            e1.printStackTrace();
        } catch (NoSuchMethodException e1) {
            // TODO: Log error
            e1.printStackTrace();
        } catch (IllegalArgumentException e) {
            // TODO: Log error
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO: Log error
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO: Log error
            e.printStackTrace();
        }
        return null;
    }

    private static <F> Object getFieldContent(String name, F from) throws SecurityException {
        String getMethodName = "get" + Character.toUpperCase(name.charAt(0)) + name.substring(1);
        String isMethodName = "is" + Character.toUpperCase(name.charAt(0)) + name.substring(1);

        Method m = null;
        try {
            m = from.getClass().getMethod(getMethodName);
        } catch (NoSuchMethodException e1) {
            try {
                m = from.getClass().getMethod(isMethodName);
            } catch (NoSuchMethodException e) {
                // TODO: Log error
                e.printStackTrace();
            }
        }
        if (m != null) {
            try {
                return m.invoke(from);
            } catch (IllegalArgumentException e) {
                // TODO: Log error
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                // TODO: Log error
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                // TODO: Log error
                e.printStackTrace();
            }
        }
        return null;
    }

    private static <T> Constructor<?> getConstracor(Class<T> to) throws NoSuchMethodException {
        for (Constructor<?> ctr : to.getConstructors()) {
            if (ctr.getParameterTypes().length > 0 &&
                    ctr.getParameterTypes()[0].equals(HttpProxy.class)) {
                return ctr;
            }
        }
        throw new NoSuchMethodException("HttpProxy");
    }

    public static <R, Z> Z map(Class<R> from, Class<Z> to, String xml, HttpProxy proxy) throws JAXBException {
        R res = SerializationHelper.unmarshall(from, xml);
        return Mapper.map(res, to, proxy);
    }
}
