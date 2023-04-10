package com.gotten.springframework.beans.factory;

/**
 * @author gaoteng
 * @version v1.0
 * @date 2023/4/3 19:59
 * @description
 */
public interface InitializingBean {

    /**
     * Bean 处理了属性填充后调用
     * @throws Exception
     */
    void afterPropertiesSet() throws Exception;
}
