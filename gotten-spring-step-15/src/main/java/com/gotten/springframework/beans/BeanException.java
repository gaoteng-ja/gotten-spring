package com.gotten.springframework.beans;

/**
 * @author gaoteng
 * @version v1.0
 * @date 2023/3/31 18:19
 * @description
 */
public class BeanException extends RuntimeException{

    public BeanException(String message) {
        super(message);
    }

    public BeanException(String message, Throwable cause) {
        super(message, cause);
    }
}
