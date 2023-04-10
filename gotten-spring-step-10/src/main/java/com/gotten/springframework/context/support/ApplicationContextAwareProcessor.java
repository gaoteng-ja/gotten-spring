package com.gotten.springframework.context.support;

import com.gotten.springframework.beans.factory.ApplicationContextAware;
import com.gotten.springframework.beans.factory.config.BeanPostProcessor;
import com.gotten.springframework.context.ApplicationContext;

/**
 * @author gaoteng
 * @version v1.0
 * @date 2023/4/6 14:57
 * @description
 */
public class ApplicationContextAwareProcessor implements BeanPostProcessor {

    private final ApplicationContext applicationContext;

    public ApplicationContextAwareProcessor(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        if (bean instanceof ApplicationContextAware) {
            ((ApplicationContextAware) bean).setApplicationContext(applicationContext);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        return bean;
    }
}
