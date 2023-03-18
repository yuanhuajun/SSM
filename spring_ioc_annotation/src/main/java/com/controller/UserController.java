package com.controller;

import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

/**
 * @author yhj
 * @version 1.0
 * @date 2023/1/15 14:13
 * @Description
 */

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    public  void saveUser(){
        userService.saveUser();
    }
}
