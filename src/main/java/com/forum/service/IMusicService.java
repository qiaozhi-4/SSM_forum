package com.forum.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.forum.entity.Music;
import com.forum.entity.MusicList;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IMusicService extends IService<Music> {

    //查询单曲
    Music findById(int id);

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

    //添加歌曲到歌单
    boolean insertUserMusicList(int listId, int musicId);

    //添加歌单
    boolean insertMusicList(int userId, String name);

    //把歌曲移除歌单
    boolean deleteUserMusicList(int listId, int musicId);

    //删除歌单
    boolean deleteMusicList(int userId, String name);

    //修改歌单
    boolean updateMusicList(int userId, int id, String name);

}
