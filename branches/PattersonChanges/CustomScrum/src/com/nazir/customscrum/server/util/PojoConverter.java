package com.nazir.customscrum.server.util;

import com.nazir.customscrum.client.model.util.DomainObject;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.Collection;
import java.util.HashSet;

import org.hibernate.collection.PersistentSet;
import org.hibernate.Hibernate;

/**
 * Created by IntelliJ IDEA.
 * User: nazir
 * Date: Mar 14, 2010
 * Time: 4:52:18 AM
 * To change this template use File | Settings | File Templates.
 */
public class PojoConverter {
    public <T extends DomainObject> T convert(T object) {
        try {
            Class clazz = Hibernate.getClass(object);
            Object convertedObject = clazz.newInstance();
            BeanInfo beanInfo = Introspector.getBeanInfo(clazz);
            for (PropertyDescriptor propertyDescriptor : beanInfo.getPropertyDescriptors()) {
                Object propVal = propertyDescriptor.getReadMethod().invoke(object);
                if (propVal instanceof DomainObject) {
                    propVal = convert((DomainObject) propVal);
                }else if (propVal instanceof PersistentSet) {
                    propVal = convertCollection((PersistentSet) propVal);
                }
                if (propertyDescriptor.getWriteMethod() != null) {
                    propertyDescriptor.getWriteMethod().invoke(convertedObject, propVal);
                }
            }
            return (T) convertedObject;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


    private <T extends DomainObject> Collection<T> convertCollection(PersistentSet collection) {
        try {
            Collection convertedCollection = null;
            convertedCollection = new HashSet();
            for (Object item : collection) {
                if (item instanceof DomainObject) {
                    convertedCollection.add(convert((DomainObject) item));
                } else {
                    convertedCollection.add(item);
                }
            }
            return convertedCollection;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
