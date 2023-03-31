package com.gotten.springframework;

/**
 * @author gaoteng
 * @version v1.0
 * @date 2023/3/31 16:46
 * @description
 */
public class BeanDefinition {

    private Object bean;

    public BeanDefinition(Object bean) {
        this.bean = bean;
    }

    public Object getBean() {
        return bean;
    }
}
