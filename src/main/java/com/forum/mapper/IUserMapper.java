package com.forum.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.forum.entity.Music;
import com.forum.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IUserMapper extends BaseMapper<User> {
    List<User> findByUserIdAttention(@Param("id") int id);
    List<User> findByUserIdFans(@Param("id") int id);
}
