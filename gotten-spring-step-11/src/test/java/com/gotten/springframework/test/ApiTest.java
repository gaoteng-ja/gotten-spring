package com.gotten.springframework.test;

import com.gotten.springframework.aop.AdvisedSupport;
import com.gotten.springframework.aop.MethodMatcher;
import com.gotten.springframework.aop.TargetSource;
import com.gotten.springframework.aop.aspectJ.AspectJExpressionPointcut;
import com.gotten.springframework.aop.framework.Cglib2AopProxy;
import com.gotten.springframework.aop.framework.JdkDynamicAopProxy;
import com.gotten.springframework.test.bean.IUserService;
import com.gotten.springframework.test.bean.UserService;
import com.gotten.springframework.test.bean.UserServiceInterceptor;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author gaoteng
 * @version v1.0
 * @date 2023/3/31 16:48
 * @description
 */
public class ApiTest {

    @Test
    public void test_aop() throws NoSuchMethodException {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut(
                "execution(* com.gotten.springframework.test.bean.UserService.*(..))"
        );
        Class<UserService> clazz = UserService.class;
        Method method = clazz.getDeclaredMethod("queryUserInfo");

        System.out.println(pointcut.matches(clazz));
        System.out.println(pointcut.matches(method, clazz));
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
