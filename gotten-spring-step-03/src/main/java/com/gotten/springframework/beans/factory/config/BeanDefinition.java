package com.gotten.springframework.beans.factory.config;

/**
 * @author gaoteng
 * @version v1.0
 * @date 2023/3/31 17:37
 * @description
 */
public class BeanDefinition {

    private Class beanClass;

    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }
}
