package com.service.impl;

import com.dao.UserDao;
import com.service.UserService;

/**
 * @author yhj
 * @version 1.0
 * @date 2023/1/15 13:31
 * @Description
 */


public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void savaUser() {
        userDao.savaUser();
    }
}
