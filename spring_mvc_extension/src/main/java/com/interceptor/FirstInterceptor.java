package com.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
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
 *
 * 多个拦截器执行顺序与在SpringMVC配置文件中的配置顺序有关
 * preHandle（）按照配置顺序执行，postHandle（）和afterCompletion()按配置的反序执行
 *
 * 若拦截器中有某个拦截器preHandle（）返回false
 * 拦截器的preHandle()返回false和它之前的拦截器的preHandle（）都会执行
 * 所有拦截器的preHandle（）返回false之前的拦截器的afterCompletion()会执行
 */

@Component
public class FirstInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("FirstInterceptor->控制器方法执行之前");
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("FirstInterceptor->控制器方法执行之后");
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("FirstInterceptor->渲染视图之后");
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
