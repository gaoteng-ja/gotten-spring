package com.gotten.springframework.beans.factory.config;

import com.gotten.springframework.beans.BeanException;
import com.gotten.springframework.beans.PropertyValues;

/**
 * @author gaoteng
 * @version v1.0
 * @date 2023/4/10 18:02
 * @description
 */
public interface InstantiationAwareBeanPostProcessor extends BeanPostProcessor{

    Object postProcessBeforeInitialization(Class<?> beanClass, String beanName);

    PropertyValues postProcessPropertyValues(PropertyValues pvs, Object bean, String beanName) throws BeanException;

    boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeanException;

    default Object getEarlyBeanReference(Object bean, String beanName) {
        return bean;
    }
}
