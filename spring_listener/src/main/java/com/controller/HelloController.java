package com.controller;

import com.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author yhj
 * @version 1.0
 * @date 2023/2/25 19:35
 * @Description
 */

@Controller
public class HelloController {
    @Autowired
    private HelloService helloService;
}
