package com.forum.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.forum.entity.Topic;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ITopicMapper extends BaseMapper<Topic> {
}