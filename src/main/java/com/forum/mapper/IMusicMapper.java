package com.forum.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.forum.entity.Music;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IMusicMapper extends BaseMapper<Music> {
    List<Music> findByUserId(@Param("id") int id, @Param("name") String name);


    //根据音乐分类id查询该分类的音乐
    List<Music> findByTypeId(@Param("id") int id);

    //模糊查询
    List<Music> findByFuzzy(@Param("str") String str);


}
