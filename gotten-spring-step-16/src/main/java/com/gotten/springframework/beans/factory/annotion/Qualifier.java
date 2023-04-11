package com.gotten.springframework.beans.factory.annotion;

import java.lang.annotation.*;

/**
 * @author gaoteng
 * @version v1.0
 * @date 2023/4/11 15:07
 * @description
 */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Qualifier {

    String value() default "";
}
