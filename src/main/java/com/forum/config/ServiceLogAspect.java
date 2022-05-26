package com.forum.config;


import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

//定义切面类
public class ServiceLogAspect {
    private Logger logger = LoggerFactory.getLogger(ServiceLogAspect.class);



    //定义通知，方法执行前
    public void doBefore(JoinPoint poin) throws IOException {
        System.out.println("------------------------------------------------------");
        System.out.println("【Service】方法执行前,当前时间："+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        System.out.println("------------------------------------------------------");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 记录下请求内容
        logger.info("【Service】方法执行前,当前时间："+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        logger.info("【Service】请求URL : " + request.getRequestURL().toString());
        logger.info("【Service】请求方法 : " + request.getMethod());
        logger.info("【Service】IP地址 : " + request.getRemoteAddr());
        Enumeration<String> enu = request.getParameterNames();

        File file =new File("log.txt");
        FileWriter fileWritter = new FileWriter("log.txt",true);
        BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
        bufferWritter.write("【Service】方法执行前,当前时间："+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        bufferWritter.write("【Service】请求URL : " + request.getRequestURL().toString());
        bufferWritter.write("【Service】请求方法 : " + request.getMethod());
        bufferWritter.write("【Service】IP地址 : " + request.getRemoteAddr());

        while (enu.hasMoreElements()) {
            String name = (String) enu.nextElement();
            logger.info("【Service】参数:{},值:{}", name,new String(request.getParameter(name).getBytes("ISO-8859-1"),"utf-8"));
            bufferWritter.write("【Service】参数:" + name + ",值:" + new String(request.getParameter(name).getBytes("ISO-8859-1"),"utf-8"));
        }
        bufferWritter.close();
    }

    //定义通知，方法执行后
    public void after(JoinPoint poin) throws IOException {
        File file =new File("log.txt");
        FileWriter fileWritter = new FileWriter(file.getName(),true);
        BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
        bufferWritter.write("【Service】方法执行后,当前时间："+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        bufferWritter.close();
        logger.info("【Service】方法执行后,当前时间："+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));

    }

    //定义通知，方法返回前
    public void AfterReturning(JoinPoint poin) throws IOException {
        File file =new File("log.txt");
        FileWriter fileWritter = new FileWriter(file.getName(),true);
        BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
        bufferWritter.write("【Service】方法返回前,当前时间："+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        bufferWritter.close();
        logger.info("【Service】方法返回前,当前时间："+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }

    //定义通知，抛出异常
    public void AfterThrowing(Throwable error) throws IOException {
        File file =new File("log.txt");
        FileWriter fileWritter = new FileWriter(file.getName(),true);
        BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
        bufferWritter.write("【Service】方法报错,当前时间："+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        bufferWritter.close();
        logger.info("【Service】方法报错,当前时间："+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }

    //定义通知环绕型
    public Object Around (ProceedingJoinPoint pjp) throws Throwable{
        File file =new File("log.txt");
        FileWriter fileWritter = new FileWriter(file.getName(),true);
        BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
        bufferWritter.write("【Service】环绕前:"+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        bufferWritter.write("【Service】环绕后:"+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        bufferWritter.close();
        logger.info("【Service】环绕前:"+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        Object obj= pjp.proceed();
        logger.info("【Service】环绕后:"+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        return obj;
    }
}
