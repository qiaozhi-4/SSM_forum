package com.forum.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.forum.entity.Music;
import com.forum.entity.MusicList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IMusicListMapper extends BaseMapper<MusicList> {

}
