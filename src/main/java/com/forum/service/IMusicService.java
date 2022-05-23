package com.forum.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.forum.entity.Music;

import java.util.List;

public interface IMusicService extends IService<Music> {
    List<Music> pageAll(int pageNum);
}
