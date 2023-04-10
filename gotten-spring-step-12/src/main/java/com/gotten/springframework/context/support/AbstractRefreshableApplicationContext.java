package com.gotten.springframework.context.support;

import com.gotten.springframework.beans.BeanException;
import com.gotten.springframework.beans.factory.ConfigurableListableBeanFactory;
import com.gotten.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * @author gaoteng
 * @version v1.0
 * @date 2023/4/1 16:12
 * @description
 */
public abstract class AbstractRefreshableApplicationContext extends AbstractApplicationContext{
    private DefaultListableBeanFactory beanFactory;

    @Override
    protected void refreshBeanFactory() throws BeanException {
        DefaultListableBeanFactory beanFactory = createBeanFactory();
        loadBeanDefinitions(beanFactory);
        this.beanFactory = beanFactory;
    }

    private DefaultListableBeanFactory createBeanFactory() {
        return new DefaultListableBeanFactory();
    }

    protected abstract void loadBeanDefinitions(DefaultListableBeanFactory beanFactory);

    @Override
    protected ConfigurableListableBeanFactory getBeanFactory() {
        return beanFactory;
    }
}
