package com.tukjax.cargo.spring.bean;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyEditorSupport;
import java.util.stream.Stream;

/**
 * Java Bean里面的元信息
 */
public class BeanInfoDemo {

    public static void main(String[] args) throws IntrospectionException {
        BeanInfo beanInfo = Introspector.getBeanInfo(Cat.class, Object.class);
        Stream.of(beanInfo.getPropertyDescriptors())
        .forEach(propertyDescriptor->{
            //可以添加propertyEditor

            Class<?> propertyType = propertyDescriptor.getPropertyType();
            if("catName".equals(propertyDescriptor.getName())){
                Integer.valueOf("123");
                propertyDescriptor.setPropertyEditorClass(string2Integer.class);
            }
            System.out.println(propertyDescriptor);
        });
    }

    static class string2Integer extends PropertyEditorSupport{

        @Override
        public void setAsText(String text) throws IllegalArgumentException {
            setValue(Integer.valueOf(text));
        }
    }
}
