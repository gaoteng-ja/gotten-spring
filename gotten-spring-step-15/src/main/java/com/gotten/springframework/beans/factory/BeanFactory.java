package com.gotten.springframework.beans.factory;

import com.gotten.springframework.beans.BeanException;

/**
 * @author gaoteng
 * @version v1.0
 * @date 2023/3/31 17:50
 * @description
 */
public interface BeanFactory {

    Object getBean(String beanName);

    Object getBean(String beanName, Object... args);

    <T> T getBean(String beanName, Class<T> requiredType);

    <T> T getBean(Class<T> requiredType) throws BeanException;
}
