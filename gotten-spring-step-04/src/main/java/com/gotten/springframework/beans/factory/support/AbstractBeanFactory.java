package com.gotten.springframework.beans.factory.support;

import com.gotten.springframework.beans.BeanException;
import com.gotten.springframework.beans.factory.BeanFactory;
import com.gotten.springframework.beans.factory.config.BeanDefinition;

/**
 * @author gaoteng
 * @version v1.0
 * @date 2023/3/31 17:45
 * @description
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    @Override
    public Object getBean(String beanName) {
        return doGetBean(beanName, null);
    }

    @Override
    public Object getBean(String beanName, Object... args) {
        return doGetBean(beanName, args);
    }

    protected Object doGetBean(String beanName, Object[] args) {
        Object bean = getSingleton(beanName);
        if (bean != null) {
            return bean;
        }

        BeanDefinition beanDefinition = getBeanDefinition(beanName);
        return createBean(beanName, beanDefinition, args);
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeanException;

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeanException;
}
