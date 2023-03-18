package com.aop.xml;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author yhj
 * @version 1.0
 * @date 2023/1/17 20:14
 * @Description
 *
 */

@Component

public class ValidateAspect {
    //@Before("execution(* com.aop.annotation.CalculatorImpl.*(..))")
    @Before("com.aop.xml.LoggerAspect.pointCut()")
    public void beforeMethod(){
        System.out.println("ValidateAspect-->前置通知");
    }
}
