package com.gotten.springframework.context;

import java.util.EventListener;

/**
 * @author gaoteng
 * @version v1.0
 * @date 2023/4/7 16:05
 * @description
 */
public interface ApplicationListener<E extends ApplicationEvent> extends EventListener {

    void onApplicationEvent(E event);
}
