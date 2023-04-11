package com.gotten.springframework.aop;

import java.lang.reflect.Method;

/**
 * @author gaoteng
 * @version v1.0
 * @date 2023/4/10 14:31
 * @description
 */
public interface MethodMatcher {

    boolean matches(Method method, Class<?> targetClass);
}
