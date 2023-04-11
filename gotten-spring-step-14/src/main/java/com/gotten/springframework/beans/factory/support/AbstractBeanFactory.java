package com.gotten.springframework.beans.factory.support;

import com.gotten.springframework.beans.BeanException;
import com.gotten.springframework.beans.factory.BeanFactory;
import com.gotten.springframework.beans.factory.FactoryBean;
import com.gotten.springframework.beans.factory.config.BeanDefinition;
import com.gotten.springframework.beans.factory.config.BeanPostProcessor;
import com.gotten.springframework.beans.factory.config.ConfigurableBeanFactory;
import com.gotten.springframework.utils.ClassUtils;
import com.gotten.springframework.utils.StringValueResolver;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gaoteng
 * @version v1.0
 * @date 2023/3/31 17:45
 * @description
 */
public abstract class AbstractBeanFactory extends FactoryBeanRegistrySupport implements ConfigurableBeanFactory {

    private ClassLoader classLoader = ClassUtils.getDefaultClassLoader();

    private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<>();

    private final List<StringValueResolver> embeddedValueResolvers = new ArrayList<>();

    @Override
    public Object getBean(String beanName) {
        return doGetBean(beanName, null);
    }

    @Override
    public Object getBean(String beanName, Object... args) {
        return doGetBean(beanName, args);
    }

    @Override
    public <T> T getBean(String beanName, Class<T> requiredType) {
        return (T) getBean(beanName);
    }

    protected <T> T doGetBean(String beanName, Object[] args) {
        Object sharedInstance = getSingleton(beanName);
        if (sharedInstance != null) {
            return (T) getObjectForBeanInstance(sharedInstance, beanName);
        }

        BeanDefinition beanDefinition = getBeanDefinition(beanName);
        Object bean = createBean(beanName, beanDefinition, args);
        return (T) getObjectForBeanInstance(bean, beanName);
    }

    private Object getObjectForBeanInstance(Object beanInstance, String beanName) {
        if (!(beanInstance instanceof FactoryBean)) {
            return beanInstance;
        }

        Object object = getCacheObjectForFactoryBean(beanName);

        if (object == null) {
            FactoryBean<?> factoryBean = (FactoryBean<?>) beanInstance;
            object = getObjectFromFactoryBean(factoryBean, beanName);
        }

        return object;
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeanException;

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeanException;

    @Override
    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) {
        this.beanPostProcessors.remove(beanPostProcessor);
        this.beanPostProcessors.add(beanPostProcessor);
    }

    @Override
    public void addEmbeddedValueResolver(StringValueResolver valueResolver) {
        this.embeddedValueResolvers.add(valueResolver);
    }

    @Override
    public String resolveEmbeddedValue(String value) {
        String result = value;
        for (StringValueResolver resolver : this.embeddedValueResolvers) {
            result = resolver.resolveStringValue(result);
        }
        return result;
    }

    public List<BeanPostProcessor> getBeanPostProcessors() {
        return this.beanPostProcessors;
    }

    public ClassLoader getClassLoader() {
        return this.classLoader;
    }
}
