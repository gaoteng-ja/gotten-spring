package com.gotten.springframework.context.event;

import com.gotten.springframework.beans.BeanException;
import com.gotten.springframework.beans.factory.BeanFactory;
import com.gotten.springframework.beans.factory.BeanFactoryAware;
import com.gotten.springframework.context.ApplicationEvent;
import com.gotten.springframework.context.ApplicationListener;
import com.gotten.springframework.utils.ClassUtils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @author gaoteng
 * @version v1.0
 * @date 2023/4/7 16:31
 * @description
 */
public abstract class AbstractApplicationEventMulticaster implements ApplicationEventMulticaster, BeanFactoryAware {

    public final Set<ApplicationListener<ApplicationEvent>> applicationListeners = new LinkedHashSet<>();

    private BeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeanException {
        this.beanFactory = beanFactory;
    }

    @Override
    public void addApplicationListener(ApplicationListener<?> listener) {
        applicationListeners.add((ApplicationListener<ApplicationEvent>) listener);
    }

    @Override
    public void removeApplicationListener(ApplicationListener<?> listener) {
        applicationListeners.remove(listener);
    }

    protected Collection<ApplicationListener> getApplicationListeners(ApplicationEvent event) {
        LinkedList<ApplicationListener> allListeners = new LinkedList<>();
        for (ApplicationListener<ApplicationEvent> listener : applicationListeners) {
            if (supportEvent(listener, event)) {
                allListeners.add(listener);
            }
        }
        return allListeners;
    }

    protected boolean supportEvent(ApplicationListener<ApplicationEvent> listener, ApplicationEvent event) {
        Class<? extends ApplicationListener> listenerClass = listener.getClass();

        Class<?> targetClass = ClassUtils.isCglibProxyClass(listenerClass) ? listenerClass.getSuperclass() : listenerClass;
        Type genericInterface = targetClass.getGenericInterfaces()[0];

        Type actualTypeArgument = ((ParameterizedType) genericInterface).getActualTypeArguments()[0];
        String className = actualTypeArgument.getTypeName();

        Class<?> eventClassName;
        try {
            eventClassName = Class.forName(className);
        } catch (ClassNotFoundException e) {
            throw new BeanException("wrong event class name: " + className);
        }

        return eventClassName.isAssignableFrom(event.getClass());
    }
}
