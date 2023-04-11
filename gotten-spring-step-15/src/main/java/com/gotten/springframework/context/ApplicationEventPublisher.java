package com.gotten.springframework.context;

/**
 * @author gaoteng
 * @version v1.0
 * @date 2023/4/10 13:16
 * @description
 */
public interface ApplicationEventPublisher {

    void publishEvent(ApplicationEvent event);
}
