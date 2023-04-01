package com.gotten.springframework.beans.factory.config;

/**
 * @author gaoteng
 * @version v1.0
 * @date 2023/4/1 15:40
 * @description
 */
public interface BeanPostProcessor {

    /**
     * 在Bean对象执行初始化方法之前，执行此方法
     *
     * @param bean
     * @param beanName
     * @return
     */
    Object postProcessBeforeInitialization(Object bean, String beanName);

    /**
     * 在Bean对象执行初始化方法之后，执行此方法
     *
     * @param bean
     * @param beanName
     * @return
     */
    Object postProcessAfterInitialization(Object bean, String beanName);
}
