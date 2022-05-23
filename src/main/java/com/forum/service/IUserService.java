package com.forum.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.forum.entity.User;

import java.util.List;

public interface IUserService extends IService<User> {

    //注册
    boolean register (String username, String password1, String password2, String name, String sex);

    //我关注的
    List<User> attention (int id);

    //我的粉丝
    List<User> fans (int id);
}
