package com.gotten.springframework.test.common;

import com.gotten.springframework.beans.factory.config.BeanPostProcessor;
import com.gotten.springframework.test.bean.UserService;

/**
 * @author gaoteng
 * @version v1.0
 * @date 2023/4/3 9:15
 * @description
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        if ("userService".equals(beanName)) {
            UserService userService = (UserService) bean;
            userService.setLocation("上海");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        return bean;
    }
}
