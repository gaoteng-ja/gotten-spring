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
    public void testBeanFactoryPostProcessorAndBeanPostProcessor() {
        //1.初始化beanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        //2.读取配置文件&注册bean
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        beanDefinitionReader.loadBeanDefinitions("classpath:spring.xml");

        //3.beanDefinition加载完成 & bean实例化之前，修改beanDefinition的属性值
        MyBeanFactoryPostProcessor beanFactoryPostProcessor = new MyBeanFactoryPostProcessor();
        beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);

        //4.bean实例化之后，修改bean的属性值
        MyBeanPostProcessor beanPostProcessor = new MyBeanPostProcessor();
        beanFactory.addBeanPostProcessor(beanPostProcessor);

        //5.获取bean对象调用方法
        UserService userService = beanFactory.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        System.out.println("测试结果：" + result);
        System.out.println(userService);

    }

    @Test
    public void test_xml() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.registerShutdownHook();

        UserService userService = applicationContext.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        System.out.println("测试结果：" + result);
        System.out.println(userService);
    }
}
