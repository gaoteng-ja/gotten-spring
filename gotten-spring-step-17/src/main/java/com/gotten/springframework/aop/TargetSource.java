package com.gotten.springframework.aop;

import com.gotten.springframework.utils.ClassUtils;

/**
 * @author gaoteng
 * @version v1.0
 * @date 2023/4/10 15:42
 * @description
 */
public class TargetSource {

    private final Object target;

    public TargetSource(Object target) {
        this.target = target;
    }

    public Class<?>[] getTargetClass() {
        Class<?> clazz = this.target.getClass();
        clazz = ClassUtils.isCglibProxyClass(clazz) ? clazz.getSuperclass() : clazz;
        return clazz.getInterfaces();
    }

    public Object getTarget() {
        return this.target;
    }
}
