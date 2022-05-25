package com.forum.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.forum.entity.Music;
import com.forum.entity.MusicList;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IMusicService extends IService<Music> {

    //分类查询歌曲
    PageInfo<Music> findByTypeId(int id, int pageNum);

    //查询用户歌单里的歌曲
    PageInfo<Music> findByUserId(int id, String name, int listId,int pageNum);

    //查询所有歌单
    PageInfo<MusicList> findByUid(int uid);
    //查询某个的歌单
    MusicList findByNameAndUid(String  name, int uid);

    //模糊查询歌曲
    PageInfo<Music> findByFuzzy( String str,int pageNum);

}
