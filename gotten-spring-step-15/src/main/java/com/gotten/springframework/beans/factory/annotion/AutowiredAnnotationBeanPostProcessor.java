package com.gotten.springframework.beans.factory.annotion;

import cn.hutool.core.bean.BeanUtil;
import com.gotten.springframework.beans.BeanException;
import com.gotten.springframework.beans.PropertyValues;
import com.gotten.springframework.beans.factory.BeanFactory;
import com.gotten.springframework.beans.factory.BeanFactoryAware;
import com.gotten.springframework.beans.factory.ConfigurableListableBeanFactory;
import com.gotten.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import com.gotten.springframework.utils.ClassUtils;

import java.lang.reflect.Field;

/**
 * @author gaoteng
 * @version v1.0
 * @date 2023/4/11 15:12
 * @description
 */
public class AutowiredAnnotationBeanPostProcessor implements InstantiationAwareBeanPostProcessor, BeanFactoryAware {

    private ConfigurableListableBeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeanException {
        this.beanFactory = (ConfigurableListableBeanFactory) beanFactory;
    }

    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, Object bean, String beanName) throws BeanException {
        //1.处理@Value注解
        Class<?> clazz = bean.getClass();
        clazz = ClassUtils.isCglibProxyClass(clazz) ? clazz.getSuperclass() : clazz;
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            Value annotation = field.getAnnotation(Value.class);
            if (null != annotation) {
                String value = annotation.value();
                value = beanFactory.resolveEmbeddedValue(value);
                BeanUtil.setFieldValue(bean, field.getName(), value);
            }
        }

        //2.处理注解@Autowire
        for (Field field : fields) {
            Autowired autowired = field.getAnnotation(Autowired.class);
            if (null != autowired) {
                Class<?> type = field.getType();
                String dependentBeanName = null;
                Qualifier qualifier = field.getAnnotation(Qualifier.class);
                Object dependentBean = null;
                if (null != qualifier) {
                    dependentBeanName = qualifier.value();
                    dependentBean = beanFactory.getBean(dependentBeanName, type);
                } else {
                    dependentBean = beanFactory.getBean(type);
                }
                BeanUtil.setFieldValue(bean, field.getName(), dependentBean);
            }
        }

        return pvs;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        return null;
    }

    @Override
    public Object postProcessBeforeInitialization(Class<?> beanClass, String beanName) {
        return null;
    }
}
