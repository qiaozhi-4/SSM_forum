package com.forum.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.forum.entity.User;
import com.forum.mapper.IUserMapper;
import com.forum.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

//- 服务层相关的bean
@Service
@RequiredArgsConstructor
public class UserServicePlus extends ServiceImpl<IUserMapper, User> implements IUserService {

    private final IUserMapper userMapper;


    //注册用户
    @Override
    public boolean register(String username, String password1, String password2, String name) {
        //判断用户名是否存在
        if (userMapper.selectOne(new QueryWrapper<User>().eq("username",username)) != null){
            return false;
        }
        //判断这些不为空并且两次密码相同
        if (username != null && password1 != null &&  password1.equals(password2)){
            User user = new User();
            user.setUsername(username);
            user.setPassword(password1);
            user.setName(name);
            return save(user);
        }
        return false;
    }

    //查询我关注的用户
    @Override
    public List<User> attention(int id) {
        return userMapper.findByUserIdAttention(id);
    }

    //查询我的粉丝
    @Override
    public List<User> fans(int id) {
        return userMapper.findByUserIdFans(id);
    }
}