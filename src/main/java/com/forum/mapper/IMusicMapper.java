package com.forum.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.forum.entity.Music;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IMusicMapper extends BaseMapper<Music> {
    List<Music> findByUserId(@Param("id") int id, @Param("name") String name);

}
