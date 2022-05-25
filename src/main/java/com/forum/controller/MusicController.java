package com.forum.controller;

import com.forum.entity.Music;
import com.forum.entity.MusicList;
import com.forum.entity.User;
import com.forum.service.IMusicService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

//- 控制层相关的bean
@Controller
@RequiredArgsConstructor
//开启事务管理
@EnableTransactionManagement
public class MusicController {

    private final IMusicService musicService;


    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< 查询歌单列表和歌单歌曲列表 >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    @RequestMapping(value = "/myMusic")
    public String register(String name, String pageNum, Model model) {
        //拿到现在登录的用户
        User user = (User) model.getAttribute("user");
        //查询用户所有的歌单
        List<MusicList> musicLists = musicService.findByUid(user.getId());
        //查询用户现在点击的歌单的id
        MusicList list = musicService.findByName(name);
        //查询用户点击歌单里面的歌曲
        List<Music> musics = musicService.findByUserId(user.getId(), name, list.getId(), Integer.parseInt(pageNum));
        model.addAttribute("musicLists",musicLists);
        model.addAttribute("musics",musics);
        return "myMusic";
    }

    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< 模糊搜索 >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    @RequestMapping(value = "/fuzzy")
    public String fuzzy(String str, String pageNum, Model model) {
        int page = 1;
        if (pageNum != null){
            page = Integer.parseInt(pageNum);
        }
        List<Music> music = musicService.findByFuzzy(str, page);
        return "";
    }


}
