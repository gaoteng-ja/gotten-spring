package com.gotten.springframework.beans.factory;

/**
 * @author gaoteng
 * @version v1.0
 * @date 2023/3/31 17:50
 * @description
 */
public interface BeanFactory {

    Object getBean(String beanName);
}
