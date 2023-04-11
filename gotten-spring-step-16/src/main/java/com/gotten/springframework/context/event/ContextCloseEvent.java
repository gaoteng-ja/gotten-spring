package com.gotten.springframework.context.event;

/**
 * @author gaoteng
 * @version v1.0
 * @date 2023/4/7 15:55
 * @description
 */
public class ContextCloseEvent extends ApplicationContextEvent{

    public ContextCloseEvent(Object source) {
        super(source);
    }
}
