package com.dao.impl;

import com.dao.UserDao;

/**
 * @author yhj
 * @version 1.0
 * @date 2023/1/15 13:32
 * @Description
 */


public class UserDaoImpl2 implements UserDao {
    @Override
    public void savaUser() {
        System.out.println("保存成功");
    }
}
