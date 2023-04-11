package com.gotten.springframework.aop;

/**
 * @author gaoteng
 * @version v1.0
 * @date 2023/4/10 14:33
 * @description
 */
public interface Pointcut {

    ClassFilter getClassFilter();

    MethodMatcher getMethodMatcher();
}
