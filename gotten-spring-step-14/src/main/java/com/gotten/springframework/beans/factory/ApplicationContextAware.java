package com.gotten.springframework.beans.factory;

import com.gotten.springframework.beans.BeanException;
import com.gotten.springframework.context.ApplicationContext;

/**
 * @author gaoteng
 * @version v1.0
 * @date 2023/4/6 14:55
 * @description
 */
public interface ApplicationContextAware extends Aware{

    void setApplicationContext(ApplicationContext applicationContext) throws BeanException;
}
