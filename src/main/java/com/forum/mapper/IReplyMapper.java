package com.forum.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.forum.entity.Reply;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IReplyMapper extends BaseMapper<Reply> {
}
