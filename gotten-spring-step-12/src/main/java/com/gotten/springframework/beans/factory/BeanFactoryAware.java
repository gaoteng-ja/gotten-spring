package com.gotten.springframework.beans.factory;

import com.gotten.springframework.beans.BeanException;

/**
 * @author gaoteng
 * @version v1.0
 * @date 2023/4/6 14:51
 * @description
 */
public interface BeanFactoryAware extends Aware{

    void setBeanFactory(BeanFactory beanFactory) throws BeanException;
}
