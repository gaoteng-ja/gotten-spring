package com.gotten.springframework.test;

import com.gotten.springframework.context.support.ClassPathXmlApplicationContext;
import com.gotten.springframework.test.bean.UserService;
import com.gotten.springframework.test.event.CustomEvent;
import org.junit.Test;

/**
 * @author gaoteng
 * @version v1.0
 * @date 2023/3/31 16:48
 * @description
 */
public class ApiTest {

    @Test
    public void testEvent() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.publishEvent(new CustomEvent(applicationContext, 1L, "你好"));
        applicationContext.registerShutdownHook();
    }
}
