package com.gotten.springframework.test;

import com.gotten.springframework.aop.AdvisedSupport;
import com.gotten.springframework.aop.TargetSource;
import com.gotten.springframework.aop.aspectj.AspectJExpressionPointcut;
import com.gotten.springframework.aop.framework.Cglib2AopProxy;
import com.gotten.springframework.aop.framework.JdkDynamicAopProxy;
import com.gotten.springframework.context.support.ClassPathXmlApplicationContext;
import com.gotten.springframework.test.bean.IUserService;
import com.gotten.springframework.test.bean.UserService;
import com.gotten.springframework.test.bean.UserServiceInterceptor;
import org.junit.Test;

/**
 * @author gaoteng
 * @version v1.0
 * @date 2023/3/31 16:48
 * @description
 */
public class ApiTest {

    @Test
    public void test_aop() throws NoSuchMethodException {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        IUserService userService = applicationContext.getBean("userService", IUserService.class);
        System.out.println("测试结果：" + userService.queryUserInfo());
    }

    @Test
    public void test_dynamic() {
        IUserService userService = new UserService();

        AdvisedSupport advisedSupport = new AdvisedSupport();
        advisedSupport.setTargetSource(new TargetSource(userService));
        advisedSupport.setMethodInterceptor(new UserServiceInterceptor());
        advisedSupport.setMethodMatcher(new AspectJExpressionPointcut("execution(* com.gotten.springframework.test.bean.IUserService.*(..))"));

        IUserService proxy_jdk = (IUserService) new JdkDynamicAopProxy(advisedSupport).getProxy();
        System.out.println("测试结果：" + proxy_jdk.queryUserInfo());

        IUserService proxy_cglib = (IUserService) new Cglib2AopProxy(advisedSupport).getProxy();
        System.out.println("测试结果：" + proxy_cglib.registerUser("xh"));
    }
}
