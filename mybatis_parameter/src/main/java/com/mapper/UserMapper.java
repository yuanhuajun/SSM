package com.mapper;

import com.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.Map;
import java.util.Objects;

/**
 * @author yhj
 * @version 1.0
 * @date 2023/1/10 20:50
 * @Description
 * 1.若mapper接口方法的参数为单个字面量类型，可以通过
 * Mybatis获取参数值的两种方式：#{},${},要注意${}的单引号问题
 * #{}本质是占位符复制，${}的本质是字符串拼接
 * 2.若mapper接口方法的参数是多个
 * 此时MyBatis会将参数存在map集合中，以两种方式村塾数据 （arg0，arg1..),(param1,param2..),可混用
 *3.若mapper接口方法的参数为map集合类型的参数，就和1一样
 * 4.若mampper接口方法的参数类型为实体类类型，只需通过#{}和${}访问实体类中的属性名，就可以获取对应的属性值
 * 5.可在maapper接口方法上的参数上设置@Param注解
 * 此时MyBatis会将这些参数放在map中，以两种方式进行存储
 * 1）以@Param注解的value属性值为键,以参数为值
 * 2）以param1,param2为键，以参数为值
 */


public interface UserMapper {

    User getUserByUsername(String username);

    User checkLogin(String username,String password);

    User checkLoginByMap(Map<String,Object> map);

    void insertUser(User user);


    User checkLoginByParam(@Param("username") String username, @Param("password") String password);
}
