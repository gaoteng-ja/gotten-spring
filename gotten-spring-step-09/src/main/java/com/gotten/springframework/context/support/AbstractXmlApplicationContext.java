package com.gotten.springframework.context.support;

import com.gotten.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.gotten.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @author gaoteng
 * @version v1.0
 * @date 2023/4/1 16:30
 * @description
 */
public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext{

    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(beanFactory, this);
        String[] configLocations = getConfigLocations();
        if (null != configLocations) {
            xmlBeanDefinitionReader.loadBeanDefinitions(configLocations);
        }
    }

    protected abstract String[] getConfigLocations();
}
