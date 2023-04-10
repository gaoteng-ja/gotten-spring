package com.gotten.springframework.test;

import cn.hutool.core.io.IoUtil;
import com.gotten.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.gotten.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import com.gotten.springframework.context.support.ClassPathXmlApplicationContext;
import com.gotten.springframework.core.io.DefaultResourceLoader;
import com.gotten.springframework.core.io.Resource;
import com.gotten.springframework.test.bean.UserService;
import com.gotten.springframework.test.common.MyBeanFactoryPostProcessor;
import com.gotten.springframework.test.common.MyBeanPostProcessor;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author gaoteng
 * @version v1.0
 * @date 2023/3/31 16:48
 * @description
 */
public class ApiTest {

    @Test
    public void test_prototype() {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring.xml");
        context.registerShutdownHook();

        UserService userService01 = context.getBean("userService", UserService.class);
        UserService userService02 = context.getBean("userService", UserService.class);

        System.out.println(userService01);
        System.out.println(userService02);

        System.out.println(userService01 + " 十六进制哈希：" + Integer.toHexString(userService01.hashCode()));
        System.out.println(userService02 + " 十六进制哈希：" + Integer.toHexString(userService02.hashCode()));
    }

    @Test
    public void test_factory_bean() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring.xml");
        context.registerShutdownHook();

        UserService userService = context.getBean("userService", UserService.class);
        System.out.println("测试结果： " + userService.queryUserInfo());
    }
}
