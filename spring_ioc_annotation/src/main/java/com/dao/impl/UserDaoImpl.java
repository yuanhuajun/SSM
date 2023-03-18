package com.dao.impl;

import com.dao.UserDao;
import org.springframework.stereotype.Repository;

/**
 * @author yhj
 * @version 1.0
 * @date 2023/1/15 14:15
 * @Description
 */


@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public void savaUser() {
        System.out.println("保存成功");
    }
}
