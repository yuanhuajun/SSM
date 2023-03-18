package com.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author yhj
 * @version 1.0
 * @date 2023/2/1 13:22
 * @Description
 * preHandle():在控制器方法执行之前执行，返回值表示对控制器方法的拦截（false）或放行（true）
 * postHandle():在控制器方法执行之后执行
 * afterCompletion():在控制器方法执行之后，且渲染视图完毕之后执行
 */

@Component
public class SecondInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("SecondInterceptor->控制器方法执行之前");
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("SecondInterceptor->控制器方法执行之后");
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("SecondInterceptor->渲染视图之后");
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
