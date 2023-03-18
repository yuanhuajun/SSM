package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yhj
 * @version 1.0
 * @date 2023/2/1 13:15
 * @Description
 */

@Controller
public class TestController {
    @RequestMapping("/test/hello")
    public String testHello(){
        //测试异常处理
        int a=10/0;
        return "success";
    }

}
