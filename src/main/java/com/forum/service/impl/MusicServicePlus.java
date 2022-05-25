package com.forum.service.impl;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.forum.entity.Music;
import com.forum.entity.MusicList;
import com.forum.mapper.IMusicListMapper;
import com.forum.mapper.IMusicMapper;
import com.forum.service.IMusicService;
import com.github.pagehelper.PageHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.nio.charset.StandardCharsets;
import java.util.List;

//- 服务层相关的bean
@Service
@RequiredArgsConstructor
public class MusicServicePlus extends ServiceImpl<IMusicMapper, Music> implements IMusicService {

    private final IMusicMapper musicMapper;
    private final IMusicListMapper musicListMapper;
    private final JedisPool pool;


    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< 查询音乐 >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    @Override
    public List<Music> pageAll(int pageNum){
        PageHelper.startPage(pageNum,5);//使用分页，每页5条
        return list();
    }


    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< 分类查询歌曲 >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    @Override
    public List<Music> findByTypeId(int id, int pageNum) {
        PageHelper.startPage(pageNum,5);//使用分页，每页5条
        return musicMapper.findByTypeId(id);
    }


    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< 查询用户歌单里的歌曲 >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    @Override
    public List<Music> findByUserId(int id,String name,int listId, int pageNum) {
        //redis
        try (Jedis jedis = pool.getResource()) {
            //先查redis有没有
            String str = jedis.get("page::myMusic::" + listId + pageNum);
            if (str == null){
                PageHelper.startPage(pageNum,5);//使用分页，每页5条
                //查询mysql
                List<Music> music = musicMapper.findByUserId(id, name);
                //转字符串并存入redis
                String s = JSON.toJSONString(music);
                jedis.set("page::myMusic::" + listId + pageNum,s);
                return music;
            }
            //redis缓存有就直接转
            return JSON.parseArray(str, List.class);
        }
    }

    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< 查询用户的歌单 >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    @Override
    public List<MusicList> findByUid(int uid) {
        //redis
        try (Jedis jedis = pool.getResource()) {
            //先查redis有没有
            String str = jedis.get("musicList::" + uid);
            if (str == null){
                //查询mysql
                List<MusicList> musicLists = musicListMapper.selectList(new QueryWrapper<MusicList>().eq("user_id", uid));
                //转字符串并存入redis
                String s = JSON.toJSONString(musicLists);
                jedis.set("musicList::" + uid,s);
                return musicLists;
            }
            //redis缓存有就直接转
            return JSON.parseObject(str, List.class);
        }
    }

    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< 查询用户的歌单id >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    @Override
    public MusicList findByName(String name) {
        return musicListMapper.selectOne(new QueryWrapper<MusicList>().eq("name" , name));
    }




    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< 模糊查询歌曲 >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    @Override
    public List<Music> findByFuzzy( String str, int pageNum) {
        PageHelper.startPage(pageNum,5);//使用分页，每页5条
        return musicMapper.findByFuzzy(str);
    }


}
