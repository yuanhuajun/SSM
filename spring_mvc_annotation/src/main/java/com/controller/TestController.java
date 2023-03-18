package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yhj
 * @version 1.0
 * @date 2023/2/25 13:10
 * @Description
 */

@Controller
public class TestController {
    @RequestMapping("/test")
    public String test(){
        int a=10/0;
        return "success";
    }
}
