package com.forum.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.forum.entity.Music;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IMusicMapper extends BaseMapper<Music> {
}
