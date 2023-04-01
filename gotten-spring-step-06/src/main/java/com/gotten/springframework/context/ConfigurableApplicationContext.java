package com.gotten.springframework.context;

import com.gotten.springframework.beans.BeanException;

/**
 * @author gaoteng
 * @version v1.0
 * @date 2023/4/1 15:51
 * @description
 */
public interface ConfigurableApplicationContext extends ApplicationContext {

    /**
     * 刷新容器
     *
     * @throws BeanException
     */
    void refresh() throws BeanException;
}
