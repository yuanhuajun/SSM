package com.mapper;

import com.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author yhj
 * @version 1.0
 * @date 2023/1/11 7:49
 * @Description
 * 若sql语句查询结果为多条时，一定不能以实体类类型作为方法的返回值
 * 否则会抛出TooManyResultException
 * 若sql语句查询结果数量为1时，此时可与使用实体类型或者list集合类型作为方法的返回值
 */
public interface SelectMapper {
    /**
     * 根据id查询用户信息
     * @param id
     * @return
     */
    User getUserById(Integer id);

    /**
     * 查询所有用户信息
     * @return
     */
    List<User> getAllUser();

    /**
     * 查询用户的总数量
     * @return
     */
    Integer getCount();

    /**
     * 根据id查询用户信息为map集合
     * @param id
     * @return
     */
    Map<String,Object> getUserByIdToMap(@Param("id") Integer id);

    /**
     * 查询所有的用户信息为map集合
     * 若查询的数据有多条时，并且要将每条数据转换为map集合
     * 有两种方案
     * 1.将mapper接口方法的返回值设置为泛型是map的list集合
     * 2.通过@MapKey指定Map的key
     * @return
     */
    @MapKey("id")
    Map<String,Object> getAllUserToMap();

}
