package com.gotten.springframework.test.common;

import com.gotten.springframework.beans.BeanException;
import com.gotten.springframework.beans.PropertyValue;
import com.gotten.springframework.beans.PropertyValues;
import com.gotten.springframework.beans.factory.ConfigurableListableBeanFactory;
import com.gotten.springframework.beans.factory.config.BeanDefinition;
import com.gotten.springframework.beans.factory.config.BeanFactoryPostProcessor;

/**
 * @author gaoteng
 * @version v1.0
 * @date 2023/4/3 9:11
 * @description
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeanException {

        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");

        PropertyValues propertyValues = beanDefinition.getPropertyValues();

        propertyValues.addPropertyValue(new PropertyValue("company", "改为字节跳动"));

    }
}
