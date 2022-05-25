package com.forum.controller;

import com.alibaba.fastjson2.JSON;
import com.forum.dto.UserDTO;
import com.forum.entity.Music;
import com.forum.entity.User;
import com.forum.service.IMusicService;
import com.forum.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;

//- 控制层相关的bean
@Controller
@RequiredArgsConstructor
//开启事务管理
@EnableTransactionManagement
public class UserController {

    private final IUserService userService;
    private final IMusicService musicService;
    private final JedisPool pool;

    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< 主页 >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    @RequestMapping(value = {"/","/index"})
    public String index() {
        return "index";
    }

    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< 登录页面 >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    @RequestMapping(value = {"/loginPage"})
    public String loginPage() {
        return "login";
    }

    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< 注册页面 >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    @RequestMapping(value = {"/registerPage"})
    public String registerPage() {
        return "register";
    }





    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< 登录提交 >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(String username, String password, Model model) {
        //获取主体，任意地方都能获取
        Subject subject = SecurityUtils.getSubject();
        //判读是否已经验证登录，或者记住登录
        if (subject.isAuthenticated() || subject.isRemembered()) {
            //已经登录
            return "redirect:/";
        }
        //还没登录
        try {
            //传入需要验证的用户，以及令牌（密码）
            UsernamePasswordToken token = new UsernamePasswordToken(username,password);
            //验证登录，会进入到核心类Realm验证
            //验证成功继续运行，失败则抛出下面的异常
            subject.login(token);
            //获取Realm里面设置的主体
            User user = (User) subject.getPrincipal();
            //把主体设置到当前会话里面
            subject.getSession().setAttribute("user",UserDTO.fromUser(user));
            //转发到登录成功
            return "redirect:/";

            //验证失败就抛出不同的异常
        } catch (UnknownAccountException e) {
            model.addAttribute("error", "无此用户");
        } catch (IncorrectCredentialsException e) {
            model.addAttribute("error", "密码不正确");
        } catch (LockedAccountException e) {
            model.addAttribute("error", "用户已经被锁定");
        } catch (ExcessiveAttemptsException e) {
            model.addAttribute("error", "尝试次数过多");
        } catch (AuthenticationException e) {
            model.addAttribute("error", "认证错误");
        }
        //转发到登录失败页面
        return "redirect:fail";
    }

    //登录失败跳转页面
    @RequestMapping(value = "/fail")
    public String fail(String error ,Model model) {
        model.addAttribute("error", error);
        return "error";
    }

    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< 注册提交 >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    @RequestMapping(value = "/register")
    public String register(String username, String password1, String password2, String name, Model model) {

        if (userService.register(username, password1, password2, name)) {
            return "redirect:/loginPage";
        }
        model.addAttribute("error", "注册失败");
        return "error";

    }

    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< 查看关注我的用户 >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    @RequestMapping(value = "/attention")
    public String attention(String id, Model model) {
        List<User> attention = userService.attention(Integer.parseInt(id));
        model.addAttribute("attention", attention);
        return "attention";
    }

    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< 查看我关注的用户 >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    @RequestMapping(value = "/fans")
    public String fans(String id, Model model) {
        List<User> fans = userService.fans(Integer.parseInt(id));
        model.addAttribute("fans", fans);
        return "fans";
    }


}
