package com.gotten.springframework.beans.factory.support;

import com.gotten.springframework.beans.BeanException;
import com.gotten.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author gaoteng
 * @version v1.0
 * @date 2023/3/31 19:51
 * @description
 */
public class SimpleInstantiationStrategy implements InstantiationStrategy {

    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor constructor, Object[] args) throws BeanException {
        Class clazz = beanDefinition.getBeanClass();
        try {
            if (null != constructor) {
                return clazz.getDeclaredConstructor(constructor.getParameterTypes()).newInstance(args);
            } else {
                return clazz.getDeclaredConstructor().newInstance();
            }
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new BeanException("Fail to instantiate [" + clazz.getName() + "]", e);
        }
    }
}
