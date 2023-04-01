package com.gotten.springframework.beans.factory.support;

import com.gotten.springframework.beans.BeanException;
import com.gotten.springframework.core.io.Resource;
import com.gotten.springframework.core.io.ResourceLoader;

/**
 * @author gaoteng
 * @version v1.0
 * @date 2023/4/1 11:15
 * @description
 */
public interface BeanDefinitionReader {

    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    void loadBeanDefinitions(Resource resource) throws BeanException;

    void loadBeanDefinitions(Resource... resources) throws BeanException;

    void loadBeanDefinitions(String location) throws BeanException;

}
