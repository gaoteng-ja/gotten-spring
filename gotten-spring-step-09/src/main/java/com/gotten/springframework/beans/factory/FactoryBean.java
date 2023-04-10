package com.gotten.springframework.beans.factory;

import com.gotten.springframework.beans.BeanException;

/**
 * @author gaoteng
 * @version v1.0
 * @date 2023/4/6 18:36
 * @description
 */
public interface FactoryBean<T> {

    T getObject() throws BeanException;

    Class<T> getObjectType();

    boolean isSingleton();
    
}
