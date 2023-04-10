package com.gotten.springframework.beans.factory;

/**
 * @author gaoteng
 * @version v1.0
 * @date 2023/4/3 20:00
 * @description
 */
public interface DisposableBean {

    /**
     * Bean销毁调用
     * @throws Exception
     */
    void destroy() throws Exception;
}
