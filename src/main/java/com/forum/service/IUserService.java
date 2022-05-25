package com.forum.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.forum.entity.User;

import java.util.List;

public interface IUserService extends IService<User> {

    //注册
    boolean register (String username, String password1, String password2, String name);

    //我关注的
    List<User> attention (int id);

    //我的粉丝
    List<User> fans (int id);

    //关注其他用户
    boolean insertAttention(int userId, String name);

    //取消关注其他用户
    boolean deleteAttention(int listId, int musicId);
}
