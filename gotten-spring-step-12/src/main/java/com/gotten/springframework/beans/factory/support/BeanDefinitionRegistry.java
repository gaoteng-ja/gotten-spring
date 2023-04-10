package com.gotten.springframework.beans.factory.support;

import com.gotten.springframework.beans.factory.config.BeanDefinition;

/**
 * @author gaoteng
 * @version v1.0
 * @date 2023/3/31 18:40
 * @description
 */
public interface BeanDefinitionRegistry {

    /**
     * 向注册表中注册beanDefinition
     *
     * @param beanName
     * @param beanDefinition
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

    /**
     * 判断是否包含指定名称的BeanDefinition
     *
     * @param beanName
     * @return
     */
    boolean containsBeanDefinition(String beanName);
}
