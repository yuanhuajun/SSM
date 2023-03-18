package com.controller;

import com.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author yhj
 * @version 1.0
 * @date 2023/1/20 12:57
 * @Description 获取请求参数的方式：
 * 1、通过servletAPI获取
 * 只需再控制器方法的形参位置设置HttpServletRequest类型的形参
 * 就可与再控制器方法中使用request对象获取请求参数
 * 2、通过控制器方法形参获取
 * 只需要在控制器方法的形参位置，设置一个形参，形参的名字和请求参数的名字一致即可
 * 3、@RequestParam：将请求参数和控制器方法的形参绑定
 * @RequestParam注解的三个属性：value，required，defaultValue value：设置和形参绑定的请求参数的名字
 * required:设置是否必须传输value所对应的请求参数
 * 默认为false,表示value所对应的请求参数必须传输，否则页面报错
 * defaultValue:设置当没有传输value所对应的请求参数时，为形参设置默认值
 * 4、@RequestHeader：将请求头信息和控制器方法的形参绑定
 * 5、@CooklieValue：将cookie数据和控制器方法的形参绑定
 * 6、通过控制器方法的实体类型的形参获取请求参数时
 * 需要在控制器方法形参位置设置实体类类型的形参，要保证实体类中属性名和请求参数名字相同
 * 可以通过实体类类型的形参获取请求参数
 * 7、解决获取请求参数的乱码问题
 * 在web.xml中配置Spring的编码过滤器CharacterEncodingFilter
 */

@Controller
public class TestParamController {
    // 通过servletAPI
    @RequestMapping("/param/servletAPI")
    public String getParamByServletAPI(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username + ":" + password);
        return "success";
    }

    // 设置形参和param一样，也可以通过@RequestParam(value="userName",required="true",default="张三”) String user
    @RequestMapping("/param")
    public String getParam(
            @RequestParam(value = "userName", required = false, defaultValue = "zhangsan") String userName, String password,
            @RequestHeader(value = "referer", required = false) String referer,
            @CookieValue(" ") String jsessionid
    ) {
        System.out.println(userName + ":" + password + "------" + referer + "------cookie:" + jsessionid);
        return "success";

    }

    @RequestMapping("/param/pojo")
    public String getPojo(User user) {
        System.out.println(user);
        return "success";
    }

}
