package com.gotten.springframework.beans.factory;

import com.gotten.springframework.beans.BeanException;

/**
 * @author gaoteng
 * @version v1.0
 * @date 2023/4/6 14:53
 * @description
 */
public interface BeanNameAware extends Aware{

    void setBeanName(String beanName) throws BeanException;
}
