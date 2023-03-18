package com.mapper;

import com.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yhj
 * @version 1.0
 * @date 2023/1/11 9:08
 * @Description
 */
public interface SpecialMapper {
    /**
     * 通过用户名模糊查询用户信息
     * @param mohu
     * @return
     */
    List<User> getUserByLike(@Param("mohu") String mohu);

    /**
     * 批量删除
     * @param ids
     */
    void deleteMoreUser(@Param("ids") String ids);

    /**
     * 动态设置表名，查询用户信息
     * @param tableName
     * @return
     */
        List<User> getUserList(@Param("tableName") String tableName);

    /**
     * 添加用户信息并获取自增逐渐
     * @param user
     */
    void insertUser(User user);

}
