package com.gotten.springframework.context.event;

/**
 * @author gaoteng
 * @version v1.0
 * @date 2023/4/7 15:56
 * @description
 */
public class ContextRefreshEvent extends ApplicationContextEvent {

    public ContextRefreshEvent(Object source) {
        super(source);
    }
}
