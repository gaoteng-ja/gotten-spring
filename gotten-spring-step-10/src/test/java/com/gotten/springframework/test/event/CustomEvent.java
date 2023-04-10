package com.gotten.springframework.test.event;

import com.gotten.springframework.context.event.ApplicationContextEvent;

/**
 * @author gaoteng
 * @version v1.0
 * @date 2023/4/10 13:47
 * @description
 */
public class CustomEvent extends ApplicationContextEvent {

    private Long id;

    private String message;

    public CustomEvent(Object source, Long id, String message) {
        super(source);
        this.id = id;
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
