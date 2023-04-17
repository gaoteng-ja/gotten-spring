package com.gotten.springframework.beans.factory;

import com.gotten.springframework.beans.BeanException;

/**
 * @author gaoteng
 * @version v1.0
 * @date 2023/4/11 18:28
 * @description
 */
public interface ObjectFactory<T> {

    T getObject() throws BeanException;


}
