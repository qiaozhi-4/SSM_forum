package com.forum.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.forum.entity.User;
import com.forum.mapper.IUserMapper;
import com.forum.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

//- 服务层相关的bean
@Service
@RequiredArgsConstructor
public class UserServicePlus extends ServiceImpl<IUserMapper, User> implements IUserService {

    private final IUserMapper userMapper;

    @Override
    public int register(String username, String password1, String password2) {
        if (username == null || password1 == null || ! password1.equals(password2)){
            return 0;
        }
        User user = new User();
        user.setUsername(username);
        user.setPassword(password1);
        return userMapper.insert(user);
    }
}
