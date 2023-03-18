package com.process;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author yhj
 * @version 1.0
 * @date 2023/1/15 11:33
 * @Description
 */


public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        // 此方法在bean生命周期初始化之前执行
        System.out.println("后置处理器->postProcessBeforeInitialization方法");
        return bean;

    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        // 此方法在bean生命周期初始化之后执行
        System.out.println("后置处理器->postProcessAfterInitialization方法");
        return bean;
    }
}
