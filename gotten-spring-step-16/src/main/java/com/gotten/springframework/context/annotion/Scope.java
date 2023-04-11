package com.gotten.springframework.context.annotion;

import java.lang.annotation.*;

/**
 * @author gaoteng
 * @version v1.0
 * @date 2023/4/11 10:12
 * @description
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Scope {

    String value() default "singleton";
}
