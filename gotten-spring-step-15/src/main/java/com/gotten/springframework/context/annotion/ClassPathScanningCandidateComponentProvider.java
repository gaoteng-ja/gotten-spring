package com.gotten.springframework.context.annotion;

import cn.hutool.core.util.ClassUtil;
import com.gotten.springframework.beans.factory.config.BeanDefinition;
import com.gotten.springframework.stereotype.Component;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author gaoteng
 * @version v1.0
 * @date 2023/4/11 10:21
 * @description
 */
public class ClassPathScanningCandidateComponentProvider {

    public Set<BeanDefinition> findCandidateComponents(String basePackage) {

        Set<BeanDefinition> candidates = new LinkedHashSet<>();

        Set<Class<?>> classes = ClassUtil.scanPackageByAnnotation(basePackage, Component.class);
        for (Class<?> clazz : classes) {
            candidates.add(new BeanDefinition(clazz));
        }
        return candidates;
    }
}
