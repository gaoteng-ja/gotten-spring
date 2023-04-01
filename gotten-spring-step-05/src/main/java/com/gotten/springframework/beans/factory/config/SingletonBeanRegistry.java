package com.gotten.springframework.beans.factory.config;

/**
 * @author gaoteng
 * @version v1.0
 * @date 2023/3/31 17:39
 * @description
 */
public interface SingletonBeanRegistry {

    Object getSingleton(String beanName);
}
