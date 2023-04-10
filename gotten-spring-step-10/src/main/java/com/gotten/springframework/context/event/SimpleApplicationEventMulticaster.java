package com.gotten.springframework.context.event;

import com.gotten.springframework.beans.factory.BeanFactory;
import com.gotten.springframework.context.ApplicationEvent;
import com.gotten.springframework.context.ApplicationListener;

/**
 * @author gaoteng
 * @version v1.0
 * @date 2023/4/10 13:27
 * @description
 */
public class SimpleApplicationEventMulticaster extends AbstractApplicationEventMulticaster {

    public SimpleApplicationEventMulticaster(BeanFactory beanFactory) {
        setBeanFactory(beanFactory);
    }

    @Override
    public void multicastEvent(final ApplicationEvent event) {
        for (final ApplicationListener listener : getApplicationListeners(event)) {
            listener.onApplicationEvent(event);
        }

    }
}
