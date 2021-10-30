package com.example.demo.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //Controller 方法执行前
//        System.out.println("preHandle");
//        System.out.println(request.getMethod());
//        System.out.println(request.getRequestURL());
//        System.out.println(request.getHeader("Accept"));
//        System.out.println(handler);
        return true;
    }



    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        //1，preHandle 返回true 2 Controller 方法执行后 在DispatcherServlet进行视图的渲染之前 执行
        // System.out.println("postHandle");

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
       // 在整个请求完成之后，也就是DispatcherServlet渲染了视图执行
       // System.out.println("afterCompletion");

    }
}
