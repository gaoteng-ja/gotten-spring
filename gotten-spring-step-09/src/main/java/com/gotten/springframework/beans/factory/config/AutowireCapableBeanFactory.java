package com.gotten.springframework.beans.factory.config;

import com.gotten.springframework.beans.BeanException;
import com.gotten.springframework.beans.factory.BeanFactory;

/**
 * @author gaoteng
 * @version v1.0
 * @date 2023/4/1 15:30
 * @description
 */
public interface AutowireCapableBeanFactory extends BeanFactory {

    /**
     * 执行BeanPostProcessors接口实现类的postProcessBeforeInitialization方法
     *
     * @param existingBean
     * @param beanName
     * @return
     * @throws BeanException
     */
    Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName) throws BeanException;

    /**
     * 执行BeanPostProcessors接口实现类的postProcessAfterInitialization方法
     *
     * @param existingBean
     * @param beanName
     * @return
     * @throws BeanException
     */
    Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName) throws BeanException;

}
