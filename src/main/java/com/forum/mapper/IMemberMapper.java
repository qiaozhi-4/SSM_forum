package com.forum.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.forum.entity.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IMemberMapper extends BaseMapper<Member> {
}
