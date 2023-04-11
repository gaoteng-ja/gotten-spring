package com.gotten.springframework.beans.factory.annotion;

import java.lang.annotation.*;

/**
 * @author gaoteng
 * @version v1.0
 * @date 2023/4/11 15:08
 * @description
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Documented
public @interface Value {

    String value();
}
