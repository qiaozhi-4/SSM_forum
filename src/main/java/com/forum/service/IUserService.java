package com.forum.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.forum.entity.User;

public interface IUserService extends IService<User> {

    //注册
    boolean register (String username, String password1, String password2, String name, String sex);
}
