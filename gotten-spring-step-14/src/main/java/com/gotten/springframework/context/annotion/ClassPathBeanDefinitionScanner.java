package com.gotten.springframework.context.annotion;

import cn.hutool.core.util.StrUtil;
import com.gotten.springframework.beans.factory.annotion.AutowiredAnnotationBeanPostProcessor;
import com.gotten.springframework.beans.factory.config.BeanDefinition;
import com.gotten.springframework.beans.factory.support.BeanDefinitionRegistry;
import com.gotten.springframework.stereotype.Component;

import java.util.Set;

/**
 * @author gaoteng
 * @version v1.0
 * @date 2023/4/11 10:28
 * @description
 */
public class ClassPathBeanDefinitionScanner extends ClassPathScanningCandidateComponentProvider{

    private BeanDefinitionRegistry registry;

    public ClassPathBeanDefinitionScanner(BeanDefinitionRegistry registry) {
        this.registry = registry;
    }

    public void doScan(String... packages) {
        for (String basePackage : packages) {
            Set<BeanDefinition> candidates = findCandidateComponents(basePackage);
            for (BeanDefinition beanDefinition : candidates) {
                String beanScope = resolveBeanScope(beanDefinition);
                if (StrUtil.isNotBlank(beanScope)) {
                    beanDefinition.setScope(beanScope);
                }
                registry.registerBeanDefinition(determineBeanName(beanDefinition), beanDefinition);
            }
        }

        registry.registerBeanDefinition("com.gotten.springframework.context.annotation.internalAutowiredAnnotationProcessor", new BeanDefinition(AutowiredAnnotationBeanPostProcessor.class));
    }

    private String resolveBeanScope(BeanDefinition beanDefinition) {
        Class<?> beanClass = beanDefinition.getBeanClass();
        Scope scope = beanClass.getAnnotation(Scope.class);
        if (null != scope) {
            return scope.value();
        }
        return StrUtil.EMPTY;
    }

    private String determineBeanName(BeanDefinition beanDefinition) {
        Class<?> beanClass = beanDefinition.getBeanClass();
        Component component = beanClass.getAnnotation(Component.class);
        String value = component.value();
        if (StrUtil.isBlank(value)) {
            value = StrUtil.lowerFirst(beanClass.getSimpleName());
        }
        return value;
    }
}
