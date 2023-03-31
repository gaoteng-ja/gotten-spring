package com.gotten.springframework;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author gaoteng
 * @version v1.0
 * @date 2023/3/31 16:47
 * @description
 */
public class BeanFactory {

    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    public Object getBean(String name) {
        return beanDefinitionMap.get(name).getBean();
    }

    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(name, beanDefinition);
    }
}
