package com.aop.xml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;


    @Component
    public class LoggerAspect {

    //切入点表达式定位的是哪个方法，当前的joinPoint表示的就是哪一个方法的信息
    public void beforeAdviceMethod(JoinPoint joinPoint){
        //获取连接点对应方法的签名信息
        Signature signature = joinPoint.getSignature();
        //获取连接点对应方法的参数
        Object[] args = joinPoint.getArgs();
        System.out.println("LoggerAspect:前置通知:"+signature.getName()+"；参数:"+ Arrays.toString(args));

    }


    public void afterAdviceMethod(JoinPoint joinPoint){
        //获取连接点对应方法的签名信息
        Signature signature = joinPoint.getSignature();
        //获取连接点对应方法的参数
        Object[] args = joinPoint.getArgs();
        System.out.println("LoggerAspect:后置通知:"+signature.getName()+"参数:"+ Arrays.toString(args));

        }


    /*
        在返回通知中要获取目标对象的返回值，只需要通过@AfterReturning注解的returning属性
        就可以将通知方法的某个参数指定为接收目标对象方法的返回值的参数
     */

    public void afterReturningAdviceMethod(JoinPoint joinPoint,Object result){
        //获取连接点对应方法的签名信息
        Signature signature = joinPoint.getSignature();
        //获取连接点对应方法的参数
        Object[] args = joinPoint.getArgs();
        System.out.println("LoggerAspect:返回通知:"+signature.getName()+"返回值:"+ result);
    }

    public void afterThrowingAdviceMethod(JoinPoint joinPoint,Exception ex){
        Signature signature = joinPoint.getSignature();
        System.out.println("LoggerAspect:异常通知:"+ex);

    }

    //环绕通知的方法要和目标对象的方法返回值一致
    public Object arroundAdviceMethod(ProceedingJoinPoint joinPoint){
        Object result = null;
        //表示目标对象方法的执行
        try {
            System.out.println("环绕通知-->前置通知");
             result = joinPoint.proceed();
            System.out.println("环绕通知-->返回通知");
        } catch (Throwable e) {
            System.out.println("环绕通知-->异常通知");
            throw new RuntimeException(e);
        } finally {
            System.out.println("环绕通知-->后置通知");
        }
        return  result;
    }
}
