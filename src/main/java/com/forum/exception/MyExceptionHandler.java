package com.forum.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyExceptionHandler implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ModelAndView view = new ModelAndView();
        if (ex instanceof MyException) {
            view.addObject("error","自定义异常信息："+ex);
        }
        view.addObject("error","异常信息："+ex);
        view.setViewName("error");
        return view;
    }
}
