package com.forum.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.forum.entity.Music;
import com.forum.mapper.IMusicMapper;
import com.forum.service.IMusicService;
import com.github.pagehelper.PageHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

//- 服务层相关的bean
@Service
@RequiredArgsConstructor
public class MusicServicePlus extends ServiceImpl<IMusicMapper, Music> implements IMusicService {

    private final IMusicMapper musicMapper;

    //分页查询音乐
    @Override
    public List<Music> pageAll(int pageNum){
        PageHelper.startPage(pageNum,5);//使用分页，每页5条
        return list();
    }

    //分类查询歌曲
    @Override
    public List<Music> findByTypeId(int id, int pageNum) {
        PageHelper.startPage(pageNum,5);//使用分页，每页5条
        return musicMapper.findByTypeId(id);
    }

    //查询用户歌单里的歌曲
    @Override
    public List<Music> findByUserId(int id, String name,int pageNum) {
        PageHelper.startPage(pageNum,5);//使用分页，每页5条
        return musicMapper.findByUserId(id, name);
    }

    //模糊查询歌曲
    @Override
    public List<Music> findByFuzzy( String str, int pageNum) {
        PageHelper.startPage(pageNum,5);//使用分页，每页5条
        return musicMapper.findByFuzzy(str);
    }


}
