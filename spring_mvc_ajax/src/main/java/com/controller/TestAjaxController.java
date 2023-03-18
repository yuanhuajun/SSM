package com.controller;

import com.pojo.User;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yhj
 * @version 1.0
 * @date 2023/1/31 23:49
 * @Description
 * @RequestBody :将请求体中的内容和控制器方法的形参进行绑定，从而获取请求体中 的内容
 */


@Controller
public class TestAjaxController {
    @RequestMapping("/test/ajax")
    public void testAjax(Integer id, HttpServletResponse response, @RequestBody String requestBody){
        System.out.println("id:"+id);
        System.out.println(requestBody);
        try {
            response.getWriter().write("hello,axios");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /*
       使用@RequestBody注解将json格式数据请求转为java对象
       1.导入jackson依赖
       2.<mvc:annotation-driven></mvc:annotation-driven>
       3.在处理请求的控制器方法的形参位置，直接设置json格式的请求参数要转换java类型的形参，使用@RequestBody注解标识即可
     */

    @RequestMapping("/test/RequestBody/json")
    //@RequestBody Map<String,Object> map ;对应实体类就用实体类，不对应就用Map
    public void testRequestBody(HttpServletResponse response, @RequestBody User user) throws IOException {
        response.getWriter().write("hello,requestbody");
        System.out.println(user);
    }

    /*
    使用@ResponseBody注解响应浏览器json格式的数据
       1.导入jackson依赖
       2.<mvc:annotation-driven></mvc:annotation-driven>
       3.在处理请求的控制器方法的形参位置，直接设置json格式的请求参数要转换java类型的形参，使用@ResponseBody注解标识控制器方法
         就可以将java对象直接转换为json字符串，并响应到浏览器
     */
    //响应内容为字符串
    @RequestMapping("/test/ResponseBody")
    @ResponseBody
    public String testResponseBody(){
        return "success";
    }

    //向浏览器响应实体
    // @RequestMapping("/test/ResponseBody/json")
    // @ResponseBody
    // public User testResponseBodyJson(){
    //     User user = new User(10001,"admin","123456",20,"男");
    //     return user;
    // }

    //向浏览器响应Map
    // @RequestMapping("/test/ResponseBody/json")
    // @ResponseBody
    // public Map<String,Object> testResponseBodyJson(){
    //     User user1 = new User(10001,"admin","123456",20,"男");
    //     User user2 = new User(10002,"admin2","123456",20,"男");
    //     User user3= new User(10003,"admin3","123456",20,"男");
    //     Map<String,Object> map = new HashMap<>();
    //     map.put("1001",user1);
    //     map.put("1002",user2);
    //     map.put("1003",user3);
    //     return map;
    // }

    //向浏览器响应数组
    @RequestMapping("/test/ResponseBody/json")
    @ResponseBody
    public List testResponseBodyJson(){
        User user1 = new User(1001,"admin","123456",20,"男");
        User user2 = new User(1002,"admin2","123456",20,"男");
        User user3= new User(1003,"admin3","123456",20,"男");
        List list = new ArrayList();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        return list;
    }
}
