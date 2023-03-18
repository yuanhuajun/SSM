package com.controller;

import com.service.UserService;

/**
 * @author yhj
 * @version 1.0
 * @date 2023/1/15 13:30
 * @Description
 */


public class UserController {
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    public void saveUser(){
        userService.savaUser();
    }
}
