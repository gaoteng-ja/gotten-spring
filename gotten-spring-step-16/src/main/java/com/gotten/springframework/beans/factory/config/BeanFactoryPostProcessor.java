package com.gotten.springframework.beans.factory.config;

import com.gotten.springframework.beans.BeanException;
import com.gotten.springframework.beans.factory.ConfigurableListableBeanFactory;

/**
 * @author gaoteng
 * @version v1.0
 * @date 2023/4/1 15:20
 * @description
 */
public interface BeanFactoryPostProcessor {

    /**
     * 在所有的BeanDefinition加载完成后，实例化Bean之前，提供修改BeanDefinition的机制
     * @param beanFactory
     * @throws BeanException
     */
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeanException;
}
