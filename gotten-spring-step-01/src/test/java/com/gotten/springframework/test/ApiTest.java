package com.gotten.springframework.test;

import com.gotten.springframework.BeanDefinition;
import com.gotten.springframework.BeanFactory;
import com.gotten.springframework.test.bean.UserService;
import org.junit.Test;

/**
 * @author gaoteng
 * @version v1.0
 * @date 2023/3/31 16:48
 * @description
 */
public class ApiTest {

    @Test
    public void testBeanFactory() {

        //1.初始化beanFactory
        BeanFactory beanFactory = new BeanFactory();

        //2.注册bean
        BeanDefinition beanDefinition = new BeanDefinition(new UserService());
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        //3.获取bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();

    }
}
