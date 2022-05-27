package com.forum.service.impl;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.forum.entity.Music;
import com.forum.entity.MusicList;
import com.forum.entity.UserMusic;
import com.forum.mapper.IMusicListMapper;
import com.forum.mapper.IMusicMapper;
import com.forum.mapper.IUserMusicMapper;
import com.forum.service.IMusicService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;

//- 服务层相关的bean
@Service
@RequiredArgsConstructor
public class MusicServicePlus extends ServiceImpl<IMusicMapper, Music> implements IMusicService {

    private final IMusicMapper musicMapper;
    private final IMusicListMapper musicListMapper;
    private final IUserMusicMapper userMusicMapper;
    private final JedisPool pool;

    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< 查询单曲 >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    @Override
    public Music findById(int id) {
        return getById(id);
    }

    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< 分类查询歌曲 >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    @Override
    public PageInfo<Music> findByTypeId(int id, int pageNum) {
        //redis
        try (Jedis jedis = pool.getResource()) {
            //先查redis有没有
            String str = jedis.get("page::typeMusic::" + id + pageNum);
            if (str == null) {
//                PageHelper.startPage(pageNum, 5);//使用分页，每页5条
                //查询mysql
                List<Music> music = musicMapper.findByTypeId(id);
                //转字符串并存入redis
                String s = JSON.toJSONString(music);
                jedis.set("page::typeMusic::" + id + pageNum, s);
                jedis.set("page::typeMusic::total::" + id, new PageInfo<>(music).getTotal() + "");
                return new PageInfo<>(music);
            }
            PageInfo<Music> pageInfo = new PageInfo<>(JSON.parseArray(str, Music.class));
            pageInfo.setTotal(Long.parseLong(jedis.get("page::typeMusic::total::" + id)));
            //redis缓存有就直接转
            return pageInfo;
        }
    }


    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< 查询用户歌单里的歌曲 >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    @Override
    public PageInfo<Music> findByUserId(int id, String name, int listId, int pageNum) {
        //redis
        try (Jedis jedis = pool.getResource()) {
            //先查redis有没有
            String str = jedis.get("page::myMusic::" + listId + pageNum);
            if (str == null) {
//                PageHelper.startPage(pageNum, 5);//使用分页，每页5条
                //查询mysql
                List<Music> music = musicMapper.findByUserId(id, name);
                //转字符串并存入redis
                String s = JSON.toJSONString(music);
                jedis.set("page::myMusic::" + listId + pageNum, s);
                jedis.set("page::myMusic::total::" + listId, new PageInfo<>(music).getTotal() + "");
                return new PageInfo<>(music);
            }
            PageInfo<Music> pageInfo = new PageInfo<>(JSON.parseArray(str, Music.class));
            pageInfo.setTotal(Long.parseLong(jedis.get("page::myMusic::total::" + listId)));
            //redis缓存有就直接转
            return pageInfo;
        }
    }

    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< 查询用户的歌单 >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    @Override
    public PageInfo<MusicList> findByUid(int uid) {
        //redis
        try (Jedis jedis = pool.getResource()) {
            //先查redis有没有
            String str = jedis.get("musicList::" + uid);
            if (str == null) {
                //查询mysql
                List<MusicList> musicLists = musicListMapper.selectList(new QueryWrapper<MusicList>().eq("user_id", uid));
                //转字符串并存入redis
                String s = JSON.toJSONString(musicLists);
                jedis.set("musicList::" + uid, s);
                return new PageInfo<>(musicLists);
            }
            //redis缓存有就直接转
            return new PageInfo<>(JSON.parseArray(str, MusicList.class));
        }
    }

    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< 查询用户的歌单id >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    @Override
    public MusicList findByNameAndUid(String name, int uid) {
        return musicListMapper.selectOne(new QueryWrapper<MusicList>().eq("name", name).eq("user_id", uid));
    }


    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< 模糊查询歌曲 >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    @Override
    public PageInfo<Music> findByFuzzy(String str, int pageNum) {
//        PageHelper.startPage(pageNum, 5);//使用分页，每页5条
        return new PageInfo<>(musicMapper.selectList(new QueryWrapper<Music>()
                .like("name", str).or()
                .like("singer", str)));
    }

    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< 添加歌曲到歌单 >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    @Override
    public boolean insertUserMusicList(int listId, int musicId) {
        //先查询改歌单有没有该歌曲
        UserMusic userMusic = userMusicMapper.selectOne(new QueryWrapper<UserMusic>()
                .eq("list_id", listId).eq("music_id", musicId));
        if (userMusic != null) {
            return false;
        }
        int i = userMusicMapper.insert(new UserMusic(listId, musicId));
        Music music = getById(musicId);
        musicListMapper.updateById(new MusicList(1, null,null,music.getImgUrl()));
        //清理redis
        try (Jedis jedis = pool.getResource()) {
            if (i!= 0){
                jedis.del("page::myMusic::" + listId +"*");
            }
        }
        return i != 0;
    }

    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< 添加歌单 >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    @Override
    public boolean insertMusicList(int userId, String name) {
        //先查询改用户有没有同名的歌单
        MusicList musicList = musicListMapper.selectOne(new QueryWrapper<MusicList>()
                .eq("user_id", userId).eq("name", name));
        if (musicList != null) {
            return false;
        }
        int i = musicListMapper.insert(new MusicList(null, userId, name,"/images/109951163327265762.jpg"));
        //清理redis
        try (Jedis jedis = pool.getResource()) {
            if (i!= 0){
                jedis.del("musicList::" + userId);
            }
        }
        return i != 0;
    }

    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< 把歌曲移除歌单 >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    @Override
    public boolean deleteUserMusicList(int listId, int musicId) {
        int i = userMusicMapper.delete(new QueryWrapper<UserMusic>()
                .eq("list_id", listId).eq("music_id", musicId));
        //清理redis
        try (Jedis jedis = pool.getResource()) {
            if (i!= 0){
                jedis.del("page::myMusic::" + listId +"*");
            }
        }
        return i != 0;
    }

    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< 删除歌单 >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    @Override
    public boolean deleteMusicList(int userId, String name) {
        int i = musicListMapper.delete(new QueryWrapper<MusicList>()
                .eq("user_id", userId).eq("name", name));
        //清理redis
        try (Jedis jedis = pool.getResource()) {
            if (i!= 0){
                jedis.del("musicList::" + userId);
            }
        }
        return i != 0;
    }

    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< 修改歌单名 >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    @Override
    public boolean updateMusicList(int userId, int id, String name) {
        int i = musicListMapper.updateById(new MusicList(id,userId,name,null));
        //清理redis
        try (Jedis jedis = pool.getResource()) {
            if (i!= 0){
                jedis.del("musicList::" + userId);
            }
        }
        return i != 0;
    }


}
