package com.gotten.springframework.test;

import cn.hutool.core.io.IoUtil;
import com.gotten.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.gotten.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import com.gotten.springframework.core.io.DefaultResourceLoader;
import com.gotten.springframework.core.io.Resource;
import com.gotten.springframework.test.bean.UserService;
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

    private DefaultResourceLoader resourceLoader;

    @Before
    public void init() {
        resourceLoader = new DefaultResourceLoader();
    }

    @Test
    public void testClassPath() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }

    @Test
    public void testFile() throws IOException {
        Resource resource = resourceLoader.getResource("src/test/resources/important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }

    @Test
    public void testURL() throws IOException {
        Resource resource = resourceLoader.getResource("https://github.com/gaoteng-ja/gotten-spring/blob/main/gotten-spring-step-05/src/test/resources/important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }

    @Test
    public void testXml() {
        //1.初始化BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        //2.读取配置文件&注册bean
        XmlBeanDefinitionReader definitionReader = new XmlBeanDefinitionReader(beanFactory);
        definitionReader.loadBeanDefinitions("classpath:spring.xml");

        //3.获取bean对象调用方法
        UserService userService = beanFactory.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        System.out.println("测试结果：" + result);
    }
}
