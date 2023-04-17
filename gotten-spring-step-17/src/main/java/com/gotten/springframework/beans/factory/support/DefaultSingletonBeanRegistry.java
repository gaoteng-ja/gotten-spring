package com.gotten.springframework.beans.factory.support;

import com.gotten.springframework.beans.BeanException;
import com.gotten.springframework.beans.factory.DisposableBean;
import com.gotten.springframework.beans.factory.ObjectFactory;
import com.gotten.springframework.beans.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author gaoteng
 * @version v1.0
 * @date 2023/3/31 17:41
 * @description
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    protected static final Object NULL_OBJECT = new Object();

    //一级缓存 普通对象
    private Map<String, Object> singletonObjects = new HashMap<>();

    //二级缓存 提前暴露对象 没有完全实例化的对象
    protected final Map<String, Object> earlySingletonObjects = new HashMap<>();

    //三级缓存 存放代理对象
    private final Map<String, ObjectFactory<?>> singletonFactories = new HashMap<>();

    private final Map<String, DisposableBean> disposableBeans = new HashMap<>();

    @Override
    public Object getSingleton(String beanName) {
        Object singletonObject = singletonObjects.get(beanName);
        if (null == singletonObject) {
            singletonObject = earlySingletonObjects.get(beanName);
            if (null == singletonObject) {
                ObjectFactory<?> objectFactory = singletonFactories.get(beanName);
                if (objectFactory != null) {
                    singletonObject = objectFactory.getObject();
                    earlySingletonObjects.put(beanName, singletonObject);
                    singletonFactories.remove(beanName);
                }
            }
        }
        return singletonObject;
    }

    @Override
    public void registerSingleton(String beanName, Object singletonObject) {
        singletonObjects.put(beanName, singletonObject);
        earlySingletonObjects.remove(beanName);
        singletonFactories.remove(beanName);
    }

    protected void addSingletonFactory(String beanName, ObjectFactory<?> singletonFactory) {
        if (!this.singletonObjects.containsKey(beanName)) {
            this.singletonFactories.put(beanName, singletonFactory);
            this.earlySingletonObjects.remove(beanName);
        }
    }

    public void registerDisposableBean(String beanName, DisposableBean bean) {
        disposableBeans.put(beanName, bean);
    }

    public void destroySingletons() {
        Set<String> keySet = this.disposableBeans.keySet();
        Object[] disposableBeanNames = keySet.toArray();

        for (int i = disposableBeanNames.length - 1; i >= 0; i--) {
            Object beanName = disposableBeanNames[i];
            DisposableBean disposableBean = disposableBeans.remove(beanName);
            try {
                disposableBean.destroy();
            } catch (Exception e) {
                throw new BeanException("Destroy method on bean name '" + beanName + "' threw an exception", e);
            }
        }
    }
}
