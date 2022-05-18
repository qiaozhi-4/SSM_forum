package com.forum.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//异常处理器
//需要配置到springMVC配置文件中
public class MyExceptionHandler implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        //创建视图
        ModelAndView view = new ModelAndView();
        view.addObject("error", "其他异常信息" + ex);
        //设置视图名称
        view.setViewName("error");
        return view;
    }
}