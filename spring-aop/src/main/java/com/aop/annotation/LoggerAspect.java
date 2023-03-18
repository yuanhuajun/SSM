package com.aop.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author yhj
 * @version 1.0
 * @date 2023/1/17 8:10
 * @Description
 * 1、在切面中，需要通过指定的注解将方法标识为通知方法
 * @Before：前置通知，在目标对象方法执行之前执行
 * @After:  后置通知,在目标对象方法的finally字句中执行
 * @AfterReturning：返回通知：在目标对象返回值之后执行
 * 2、切入点表达式：设置在标识通知的注解的value属性中
 * 3、重用切入点表达式:    @Pointcut("execution(* com.aop.annotation.*(..))")
 *                      public void pointCut(){}
 *                      @After("pointCut()")
 * 4、获取连接点的信息，在通知方法的参数位置设置JoinPoint类型参数，就可以获取连接点所对应方法的信息
 * 5、可以通过@Order注解的value属性设置优先级，默认值为Integer的最大值，值越小，优先级越高
 * */

@Component
@Aspect//将当前组件标志为切面
public class LoggerAspect {
    //声明公共的切入点表达式
    @Pointcut("execution(* com.aop.annotation.Calculator.*(..))")
    public void pointCut(){}

    @Before("execution(* com.aop.annotation.CalculatorImpl.*(..))")
    //切入点表达式定位的是哪个方法，当前的joinPoint表示的就是哪一个方法的信息
    public void beforeAdviceMethod(JoinPoint joinPoint){
        //获取连接点对应方法的签名信息(方法的声明信息）
        Signature signature = joinPoint.getSignature();
        //获取连接点对应方法的参数
        Object[] args = joinPoint.getArgs();
        System.out.println("LoggerAspect:前置通知:"+signature.getName()+"；参数:"+ Arrays.toString(args));
    }


    @After("pointCut()")
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

    @AfterReturning( value = "pointCut()",returning = "result")
    public void afterReturningAdviceMethod(JoinPoint joinPoint,Object result){
        //获取连接点对应方法的签名信息
        Signature signature = joinPoint.getSignature();
        //获取连接点对应方法的参数327935
        Object[] args = joinPoint.getArgs();
        System.out.println("LoggerAspect:返回通知:"+signature.getName()+"返回值:"+ result);
    }

    @AfterThrowing(value = "pointCut()",throwing = "ex")
    public void afterThrowingAdviceMethod(JoinPoint joinPoint,Exception ex){
        Signature signature = joinPoint.getSignature();
        System.out.println("LoggerAspect:异常通知:"+ex);

    }


    @Around("pointCut()")
    //环绕通知的方法要和目标对象的方法返回值一致
    public Object arroundAdviceMethod(ProceedingJoinPoint joinPoint){
        Object result = null;
        //表示目标对象方法的执行
        try {
            System.out.println("环绕通知-->前置通知");
            //目标对象方法的执行
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
