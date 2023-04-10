package com.gotten.springframework.context;

import java.util.EventObject;

/**
 * @author gaoteng
 * @version v1.0
 * @date 2023/4/7 15:48
 * @description
 */
public abstract class ApplicationEvent extends EventObject {

    public ApplicationEvent(Object source) {
        super(source);
    }
}
