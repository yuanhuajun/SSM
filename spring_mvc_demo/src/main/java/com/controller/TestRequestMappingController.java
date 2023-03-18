package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author yhj
 * @version 1.0
 * @date 2023/1/19 19:44
 * @Description 1、@RequestMapping标识一个类，设置映射请求的请求路径初始信息
 * @RequestMaaping标识一个方法，设置映射请求路径的具体信息 2、@RequestMapping注解value属性，通过请求路径匹配请求，value可为数组
 * 3、@RequestMapping注解method属性，通过请求的请求方式匹配请求
 * method属性是RequestMethod类型的数组，即当前浏览器所发送的请求方式匹配method属性中的任何一种请求方式
 * 4、@RequestMapping注解的param属性，通过请求参数进行匹配，param可以使用4种表达式：
 * ”param"：表示当前所匹配的请求参数中必须携带param参数
 * “！param”：不能携带param参数
 * “param=value”：必须有param参数，且值必须为value
 * “param!=value":可以不携带param，若携带，值必须不为param
 * 5、@RequestMapping注解的headers属性，通过请求的请求头信息匹配
 * 6、SpringMVC支持ant风格的路径,设置特殊字符
 * ?:任意单个字符 (不包括?)
 * *:任意个数的任意字符（不包括？和/)
 * **:任意层数的任意目录,此方式只能将**写在两个/之间，左右不能直接连着其他字符、
 * 7、@RequestMapping注解使用路径中的占位符
 * 传统：/deleteUser?id=1
 * rest:/user/delete/1
 * 需要在@RequestMapping注解的value属性中所设置的路径中，使用{xxx}方式表示路径中的数据
 * 再通过@PathVariable注解，将占位符所标识的值和控制器的形参绑定
 */

@Controller
// @RequestMapping("/test")
public class TestRequestMappingController {
    // 此时控制器匹配的请求路径为/test/hello
    @RequestMapping(
            value = {"/hello", "/abc"},
            method = {RequestMethod.POST, RequestMethod.GET},
            params = {"username", "!password", "age=20", "gender!=女"},
            headers = {"referer"}
    )
    public String success() {
        return "success";
    }

    @RequestMapping("/**/test/ant")
    public String testAnt() {
        return "success";
    }

    @RequestMapping("test/rest/{username}/{id}")
    public String testRest(@PathVariable("id") Integer id, @PathVariable("username") String username) {
        System.out.println("id:" + id);
        System.out.println("username:" + username);
        return "success";
    }
}
