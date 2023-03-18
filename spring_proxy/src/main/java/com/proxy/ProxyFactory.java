package com.proxy;

import org.omg.CORBA.DynAnyPackage.Invalid;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @author yhj
 * @version 1.0
 * @date 2023/1/15 19:17
 * @Description
 * 不是代理类，而是动态生成目标类的代理类的工厂
 */


public class ProxyFactory {
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    public Object getProxy(){
        //ClassLoader loader,指定加载动态生成的代理类的类加载器
        //Class<?>[] interfaces,获取目标对象实现的所有接口的class数组
        //InvocationHandler h 设置代理类中的抽象方法如何重写
        InvocationHandler h = new InvocationHandler(){
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //target是目标对象,proxy表示代理对象、method表示要执行的方法，args表示要执行方法的参数列表
                System.out.println("日志：方法："+method.getName()+",参数："+ Arrays.toString(args));
                Object result = method.invoke(target, args);
                System.out.println("日志：结果："+result);
                return result;
            }
        };
        ClassLoader classLoader = ProxyFactory.class.getClassLoader();
        Class<?>[] interfaces = target.getClass().getInterfaces();
        return Proxy.newProxyInstance(classLoader,interfaces,h);
    }
}
