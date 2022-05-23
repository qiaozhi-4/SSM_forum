package com.forum.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.forum.entity.User;
import com.forum.mapper.IUserMapper;
import com.forum.service.IUserService;
import org.springframework.stereotype.Service;

//- 服务层相关的bean
@Service
public class UserServicePlus extends ServiceImpl<IUserMapper, User> implements IUserService {
}
