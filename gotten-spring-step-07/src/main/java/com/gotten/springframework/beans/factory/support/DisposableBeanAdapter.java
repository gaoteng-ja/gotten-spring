package com.gotten.springframework.beans.factory.support;

import cn.hutool.core.util.StrUtil;
import com.gotten.springframework.beans.BeanException;
import com.gotten.springframework.beans.factory.DisposableBean;
import com.gotten.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Method;

/**
 * @author gaoteng
 * @version v1.0
 * @date 2023/4/3 20:16
 * @description
 */
public class DisposableBeanAdapter implements DisposableBean {

    private final Object bean;

    private final String beanName;

    private String destroyMethodName;

    public DisposableBeanAdapter(Object bean, String beanName, BeanDefinition beanDefinition) {
        this.bean = bean;
        this.beanName = beanName;
        this.destroyMethodName = beanDefinition.getDestroyMethodName();
    }

    @Override
    public void destroy() throws Exception {
        //1.实现接口DisposableBean
        if (bean instanceof DisposableBean) {
            ((DisposableBean) bean).destroy();
        }

        //2.配置信息destroy-method
        if (StrUtil.isNotBlank(destroyMethodName) && !(bean instanceof DisposableBean) && "destroy".equals(this.destroyMethodName)) {
            Method method = bean.getClass().getMethod(destroyMethodName);
            if (null == method) {
                throw new BeanException("Could not find an init method names '" + destroyMethodName + "' on bean with name " + beanName);
            }
            method.invoke(bean);
        }
    }
}
