package com.gotten.springframework.aop;

import java.lang.reflect.Method;

/**
 * @author gaoteng
 * @version v1.0
 * @date 2023/4/10 16:56
 * @description
 */
public interface MethodBeforeAdvice extends BeforeAdvice{

    void before(Method method, Object[] args, Object target) throws Throwable;
}
