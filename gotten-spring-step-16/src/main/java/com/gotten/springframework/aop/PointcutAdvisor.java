package com.gotten.springframework.aop;

/**
 * @author gaoteng
 * @version v1.0
 * @date 2023/4/10 17:31
 * @description
 */
public interface PointcutAdvisor extends Advisor {

    Pointcut getPointcut();
}
