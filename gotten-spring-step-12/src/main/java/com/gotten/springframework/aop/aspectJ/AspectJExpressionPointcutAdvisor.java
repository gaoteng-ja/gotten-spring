package com.gotten.springframework.aop.aspectJ;

import com.gotten.springframework.aop.Pointcut;
import com.gotten.springframework.aop.PointcutAdvisor;
import org.aopalliance.aop.Advice;

/**
 * @author gaoteng
 * @version v1.0
 * @date 2023/4/10 17:34
 * @description
 */
public class AspectJExpressionPointcutAdvisor implements PointcutAdvisor {

    private AspectJExpressionPointcut pointcut;

    private Advice advice;

    private String expression;

    public void setExpression(String expression) {
        this.expression = expression;
    }

    @Override
    public Pointcut getPointcut() {
        if (null == pointcut) {
            pointcut = new AspectJExpressionPointcut(expression);
        }
        return pointcut;
    }

    @Override
    public Advice getAdvice() {
        return advice;
    }

    public void setAdvice(Advice advice) {
        this.advice = advice;
    }
}
