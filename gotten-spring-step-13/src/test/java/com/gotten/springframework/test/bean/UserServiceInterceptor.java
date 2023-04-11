package com.gotten.springframework.test.bean;


import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.TimeInterval;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author gaoteng
 * @version v1.0
 * @date 2023/4/10 16:25
 * @description
 */
public class UserServiceInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        TimeInterval timer = DateUtil.timer();
        timer.start();

        try {
            return methodInvocation.proceed();
        } finally {
            System.out.println("监控 - Begin By AOP");
            System.out.println("方法名称：" + methodInvocation.getMethod());
            System.out.println("方法耗时：" + timer.interval());
            System.out.println("监控 - End\r\n");
        }
    }
}
