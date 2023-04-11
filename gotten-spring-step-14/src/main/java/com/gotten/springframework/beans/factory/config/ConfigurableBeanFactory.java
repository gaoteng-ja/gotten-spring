package com.gotten.springframework.beans.factory.config;

import com.gotten.springframework.beans.factory.HierarchicalBeanFactory;
import com.gotten.springframework.utils.StringValueResolver;

/**
 * @author gaoteng
 * @version v1.0
 * @date 2023/4/1 15:37
 * @description
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {

    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

    void destroySingletons();

    void addEmbeddedValueResolver(StringValueResolver valueResolver);

    String resolveEmbeddedValue(String value);
}
