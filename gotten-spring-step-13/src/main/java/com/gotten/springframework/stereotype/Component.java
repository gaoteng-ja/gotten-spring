package com.gotten.springframework.stereotype;

import java.lang.annotation.*;

/**
 * @author gaoteng
 * @version v1.0
 * @date 2023/4/11 10:16
 * @description
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Component {

    String value() default "";
}
