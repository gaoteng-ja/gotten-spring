package com.gotten.springframework.context.event;

import com.gotten.springframework.context.ApplicationEvent;
import com.gotten.springframework.context.ApplicationListener;

/**
 * @author gaoteng
 * @version v1.0
 * @date 2023/4/7 15:58
 * @description
 */
public interface ApplicationEventMulticaster {

    void addApplicationListener(ApplicationListener<?> listener);

    void removeApplicationListener(ApplicationListener<?> listener);

    void multicastEvent(ApplicationEvent event);
}
