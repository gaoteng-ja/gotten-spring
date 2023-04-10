package com.gotten.springframework.beans.factory;

import com.gotten.springframework.beans.BeanException;

/**
 * @author gaoteng
 * @version v1.0
 * @date 2023/4/6 14:52
 * @description
 */
public interface BeanClassLoaderAware extends Aware{

    void setBeanClassLoader(ClassLoader classLoader) throws BeanException;
}
