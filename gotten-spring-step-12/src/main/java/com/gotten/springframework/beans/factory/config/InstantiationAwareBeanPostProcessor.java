package com.gotten.springframework.beans.factory.config;

/**
 * @author gaoteng
 * @version v1.0
 * @date 2023/4/10 18:02
 * @description
 */
public interface InstantiationAwareBeanPostProcessor extends BeanPostProcessor{

    Object postProcessBeforeInitialization(Class<?> beanClass, String beanName);
}
