package com.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.support.HttpRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;

/**
 * @author yhj
 * @version 1.0
 * @date 2023/1/24 9:27
 * @Description
 */
@Controller
public class TestViewController {

    @RequestMapping("/test/view/thymeleaf")
    public String testThymeleaf(){
        return "success";
    }

    @RequestMapping("/test/view/forward")
    public String testInternalView(){
        //使用频率低，因为Thymeleaf本质上也是转发。而且当前InternalView在解析后，还是需要再使用到Thymeleaf视图对"/test/model"进行渲染
        return "forward:/test/model";
    }

    @RequestMapping("/test/view/redirect")
    public String testRedirectView(){
        //也是会创建两个视图，与InternalResourceView不同的是地址栏会变
        return "redirect:/test/model";
    }
}
