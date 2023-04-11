package com.gotten.springframework.aop.framework.autoproxy;

import com.gotten.springframework.aop.*;
import com.gotten.springframework.aop.aspectj.AspectJExpressionPointcutAdvisor;
import com.gotten.springframework.aop.framework.ProxyFactory;
import com.gotten.springframework.beans.BeanException;
import com.gotten.springframework.beans.PropertyValues;
import com.gotten.springframework.beans.factory.BeanFactory;
import com.gotten.springframework.beans.factory.BeanFactoryAware;
import com.gotten.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import com.gotten.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;

import java.util.Collection;

/**
 * @author gaoteng
 * @version v1.0
 * @date 2023/4/10 18:00
 * @description
 */
public class DefaultAdvisorAutoProxyCreator implements InstantiationAwareBeanPostProcessor, BeanFactoryAware {

    private DefaultListableBeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeanException {
        this.beanFactory = (DefaultListableBeanFactory) beanFactory;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        if (isInfrastructureClass(bean.getClass())) {
            return null;
        }
        Collection<AspectJExpressionPointcutAdvisor> advisors = beanFactory.getBeansOfType(AspectJExpressionPointcutAdvisor.class).values();
        for (AspectJExpressionPointcutAdvisor advisor : advisors) {
            ClassFilter classFilter = advisor.getPointcut().getClassFilter();
            if (!classFilter.matches(bean.getClass())) {
                continue;
            }

            AdvisedSupport advisedSupport = new AdvisedSupport();

            TargetSource targetSource = new TargetSource(bean);

            advisedSupport.setMethodInterceptor((MethodInterceptor) advisor.getAdvice());
            advisedSupport.setTargetSource(targetSource);
            advisedSupport.setMethodMatcher(advisor.getPointcut().getMethodMatcher());
            advisedSupport.setProxyTargetClass(false);

            return new ProxyFactory(advisedSupport).getProxy();
        }

        return bean;
    }

    @Override
    public Object postProcessBeforeInitialization(Class<?> beanClass, String beanName) {



        return null;
    }

    private boolean isInfrastructureClass(Class<?> beanClass) {
        return Advice.class.isAssignableFrom(beanClass) || Pointcut.class.isAssignableFrom(beanClass) || Advisor.class.isAssignableFrom(beanClass);
    }

    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, Object bean, String beanName) throws BeanException {
        return pvs;
    }
}
