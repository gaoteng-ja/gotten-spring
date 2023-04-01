package com.gotten.springframework.beans.factory.config;

/**
 * @author gaoteng
 * @version v1.0
 * @date 2023/4/1 10:09
 * @description
 */
public class BeanReference {

    private final String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }
}
