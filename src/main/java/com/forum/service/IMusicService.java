package com.forum.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.forum.entity.Music;
import com.forum.entity.MusicList;

import java.util.List;

public interface IMusicService extends IService<Music> {
    //分页查询歌曲
    List<Music> pageAll(int pageNum);

    //分类查询歌曲
    List<Music> findByTypeId(int id, int pageNum);

    //查询用户歌单里的歌曲
    List<Music> findByUserId(int id, String name, int listId,int pageNum);

    //查询所有歌单
    List<MusicList> findByUid(int uid);
    //查询某个的歌单
    MusicList findByName(String  name);

    //模糊查询歌曲
    List<Music> findByFuzzy( String str,int pageNum);

}
