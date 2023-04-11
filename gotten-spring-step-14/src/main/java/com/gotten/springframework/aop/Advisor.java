package com.gotten.springframework.aop;

import org.aopalliance.aop.Advice;

/**
 * @author gaoteng
 * @version v1.0
 * @date 2023/4/10 17:31
 * @description
 */
public interface Advisor {

    Advice getAdvice();
}
