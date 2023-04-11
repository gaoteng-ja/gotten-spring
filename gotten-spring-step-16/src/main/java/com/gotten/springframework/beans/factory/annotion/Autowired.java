package com.gotten.springframework.beans.factory.annotion;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author gaoteng
 * @version v1.0
 * @date 2023/4/11 15:05
 * @description
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.FIELD})
public @interface Autowired {
}
