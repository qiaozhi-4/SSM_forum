package com.forum.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.forum.entity.Comment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ICommentMapper extends BaseMapper<Comment> {
}
