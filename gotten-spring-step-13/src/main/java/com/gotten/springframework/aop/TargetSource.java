package com.gotten.springframework.aop;

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
        return this.target.getClass().getInterfaces();
    }

    public Object getTarget() {
        return this.target;
    }
}
