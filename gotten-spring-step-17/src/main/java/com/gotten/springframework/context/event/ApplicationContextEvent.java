package com.gotten.springframework.context.event;

import com.gotten.springframework.context.ApplicationContext;
import com.gotten.springframework.context.ApplicationEvent;

/**
 * @author gaoteng
 * @version v1.0
 * @date 2023/4/7 15:52
 * @description
 */
public class ApplicationContextEvent extends ApplicationEvent {

    public ApplicationContextEvent(Object source) {
        super(source);
    }

    public final ApplicationContext getApplicationContext() {
        return (ApplicationContext) getSource();
    }
}
