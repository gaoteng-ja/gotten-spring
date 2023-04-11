package com.gotten.springframework.beans.factory;

import com.gotten.springframework.beans.BeanException;
import com.gotten.springframework.beans.factory.config.AutowireCapableBeanFactory;
import com.gotten.springframework.beans.factory.config.BeanDefinition;
import com.gotten.springframework.beans.factory.config.ConfigurableBeanFactory;

/**
 * @author gaoteng
 * @version v1.0
 * @date 2023/4/1 15:25
 * @description
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {

    BeanDefinition getBeanDefinition(String beanName) throws BeanException;

    void preInstantiateSingletons() throws BeanException;
}
