package com.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author yhj
 * @version 1.0
 * @date 2023/2/25 12:29
 * @Description
 */

//将当前类标注为异常处理的组件
@ControllerAdvice
public class ExceptionController {
    //设置要处理的异常信息
    @ExceptionHandler(java.lang.ArithmeticException.class)
    public String handleException(Throwable ex , Model model){
        model.addAttribute("ex",ex);
        return "error";
    }
}
