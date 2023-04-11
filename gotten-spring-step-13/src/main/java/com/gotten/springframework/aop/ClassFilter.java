package com.gotten.springframework.aop;

/**
 * @author gaoteng
 * @version v1.0
 * @date 2023/4/10 14:34
 * @description
 */
public interface ClassFilter {

    boolean matches(Class<?> clazz);
}
