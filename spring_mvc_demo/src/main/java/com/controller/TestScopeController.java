package com.controller;

import javafx.beans.binding.ObjectExpression;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author yhj
 * @version 1.0
 * @date 2023/1/20 14:32
 * @Description
 * 向域对象共享数据：
 * 1、ModelAndView
 * 2、Model
 * 3、ModelMap
 * 4、Map
 * 5、这四种的关系：
 *      在底层，最终都是通过BindingAwareModelMap创建
 */

@Controller
public class TestScopeController {
    @RequestMapping("/test/mav")
    public ModelAndView testMAV(){
        /**
         * ModelAndView包含Model和View的功能
         * Model：向请求域中共享数据
         * View：设置逻辑视图，实现页面跳转
         */
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("testRequestScope","hello，ModelAndView");
        modelAndView.setViewName("success");
        return modelAndView;
    }


    @RequestMapping("/test/model")
    public String testModel(Model model){
        model.addAttribute("testRequestScope","hello,model");
        return "success";
    }

    @RequestMapping("/test/modelMap")
    public String testModelMap(ModelMap modelMap){
        modelMap.addAttribute("testRequestScope","hello,modelMap");
        return "success";
    }

    @RequestMapping("/test/map")
    public String testModelMap(Map<String,Object> map){
            map.put("testRequestScope","hello,map");
        return "success";
    }

    //向session域共享数据
    @RequestMapping("/test/session")
    public String testSession(HttpSession session){
        session.setAttribute("testSessionScope","hello,session");
        return "success";
    }

    //testApplicationScope
    @RequestMapping("/test/application")
    public String testApplication(HttpServletRequest request){
        ServletContext application = request.getSession().getServletContext();
        application.setAttribute("testApplicationScope","hello,application");
        return "success";
    }
}
