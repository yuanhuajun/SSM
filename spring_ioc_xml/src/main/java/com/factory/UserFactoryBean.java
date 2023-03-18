package com.factory;

import com.pojo.User;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author yhj
 * @version 1.0
 * @date 2023/1/15 13:09
 * @Description
 * FactoryBean是一个接口，需要创建一个类实现接口
 * 其中有三个方法：
 * 1、getObject() 获取一个对象交给IOC容器管理
 * 2、getObjectType() 设置所提供对象的类型
 * 3、isSingleton() 所提供对象是否单例
 * 当FactoryBean的一个实现类配置为一个bean时，会将当前类中getObjetc()返回的对象交给IOC容器管理
 */


public class UserFactoryBean implements FactoryBean<User> {

    @Override
    public User getObject() throws Exception {
        return new User();
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }

}
