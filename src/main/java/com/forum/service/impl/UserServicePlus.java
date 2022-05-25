package com.forum.service.impl;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.forum.entity.Music;
import com.forum.entity.User;
import com.forum.mapper.IUserMapper;
import com.forum.service.IUserService;
import com.github.pagehelper.PageInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;

//- 服务层相关的bean
@Service
@RequiredArgsConstructor
public class UserServicePlus extends ServiceImpl<IUserMapper, User> implements IUserService {

    private final IUserMapper userMapper;

    private final JedisPool pool;


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
        //redis
        try (Jedis jedis = pool.getResource()) {
            //先查redis有没有
            String str = jedis.get("attention::" + id);
            if (str == null){
                List<User> attention = userMapper.findByUserIdAttention(id);
                //转字符串并存入redis
                String s = JSON.toJSONString(attention);
                jedis.set("attention::" + id,s);
                //设置缓存存在时间
                jedis.expire("attention::" + id,3600L);
                return attention;
            }
            //设置缓存存在时间
            jedis.expire("attention::" + id,3600L);
            return JSON.parseArray(str, User.class);
        }
    }

    //查询我的粉丝
    @Override
    public List<User> fans(int id) {
        //redis
        try (Jedis jedis = pool.getResource()) {
            //先查redis有没有
            String str = jedis.get("fans::" + id);
            if (str == null){
                List<User> attention = userMapper.findByUserIdFans(id);
                //转字符串并存入redis
                String s = JSON.toJSONString(attention);
                jedis.set("fans::" + id,s);
                //设置缓存存在时间
                jedis.expire("fans::" + id,3600L);
                return attention;
            }
            //设置缓存存在时间
            jedis.expire("fans::" + id,3600L);
            return JSON.parseArray(str, User.class);
        }
    }

    @Override
    public boolean insertAttention(int userId, String name) {
        return false;
    }

    @Override
    public boolean deleteAttention(int listId, int musicId) {
        return false;
    }
}
