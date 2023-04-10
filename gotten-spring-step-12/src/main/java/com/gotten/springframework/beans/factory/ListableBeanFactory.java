package com.gotten.springframework.beans.factory;

import com.gotten.springframework.beans.BeanException;

import java.util.Map;

/**
 * @author gaoteng
 * @version v1.0
 * @date 2023/4/1 15:25
 * @description
 */
public interface ListableBeanFactory extends BeanFactory {

    /**
     * 按照类型返回bean实例
     *
     * @param type
     * @param <T>
     * @return
     * @throws BeanException
     */
    <T> Map<String, T> getBeansOfType(Class<T> type) throws BeanException;

    /**
     * 返回注册表中所有bean的名称
     *
     * @return
     */
    String[] getBeanDefinitionNames();
}
