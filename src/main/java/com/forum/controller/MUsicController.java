package com.forum.controller;

import com.alibaba.fastjson2.JSON;
import com.forum.entity.Music;
import com.forum.entity.User;
import com.forum.service.IMusicService;
import com.forum.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;

//- 控制层相关的bean
@Controller
@RequiredArgsConstructor
//开启事务管理
@EnableTransactionManagement
public class MUsicController {

    private final IMusicService musicService;
    private final JedisPool pool;



    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< 歌单 >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    @RequestMapping(value = "/Playlist")
    public String register(String id, String name,String pageNum,Model model) {
        //redis
        try (Jedis jedis = pool.getResource()) {
            //先查redis有没有
            String str = jedis.get("page::Playlist" + pageNum);
            if (str == null) {
                List<Music> musics = musicService.pageAll(1);
                //存入redis
                jedis.set("page::Playlist" + pageNum, JSON.toJSONString(musics));
                model.addAttribute("Playlist", musics);
                return "Playlist";
            }
            List musics = JSON.parseObject(str, List.class);
            model.addAttribute("musics", musics);
        }
        return "Playlist";
    }


}
