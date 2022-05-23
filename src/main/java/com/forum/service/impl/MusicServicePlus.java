package com.forum.service.impl;

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
        PageHelper.startPage(pageNum,5);//使用分页，查询第二页，每页5条
        return list();
    }

}
