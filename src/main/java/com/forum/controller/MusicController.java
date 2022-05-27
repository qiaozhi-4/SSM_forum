package com.forum.controller;

import com.forum.dto.UserDTO;
import com.forum.entity.Music;
import com.forum.entity.MusicList;
import com.forum.service.IMusicService;
import com.github.pagehelper.PageInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//- 控制层相关的bean
@Controller
@RequiredArgsConstructor
//开启事务管理
@EnableTransactionManagement
public class MusicController {

    private final IMusicService musicService;

    //每次运行设置上下文路径
    @ModelAttribute
    public void model(Model model, HttpServletRequest request){
        String contextPath = request.getContextPath();
        model.addAttribute("$",contextPath);
    }

    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< 查询歌单列表和歌单歌曲列表 >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    @RequestMapping(value = "/myMusic")
    public String register(String name, String pageNum, Model model, HttpSession session) {
        if (name == null){
            name = "我喜欢的音乐";
        }
        int page = 1;
        if (pageNum != null){
            page = Integer.parseInt(pageNum);
        }
        //拿到现在登录的用户
        UserDTO user = (UserDTO) session.getAttribute("user");
        //查询用户所有的歌单
        PageInfo<MusicList> musicLists = musicService.findByUid(user.getId());
        Map<String, List<Music>> map = new HashMap<>();
        for (MusicList musicList : musicLists.getList()) {
            PageInfo<Music> musicPageInfo = musicService.findByUserId(user.getId(), name, musicList.getId(), page);
            map.put(musicList.getName(),musicPageInfo.getList());
        }
        model.addAttribute("musicLists",musicLists.getList());
        model.addAttribute("musicListsInfo",musicLists);

        model.addAttribute("map",map);


        return "myMusic";
    }

    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< 模糊搜索 >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    @RequestMapping(value = "/fuzzy")
    public String fuzzy(String musicName, String pageNum, Model model) {
        int page = 1;
        if (pageNum != null){
            page = Integer.parseInt(pageNum);
        }
        PageInfo<Music> musics = musicService.findByFuzzy(musicName, page);

        model.addAttribute("musics",musics.getList());
        model.addAttribute("musicsInfo",musics);
        model.addAttribute("str", musicName);
        return "fuzzy";
    }

    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< 添加歌单 >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    @RequestMapping(value = "/addMusicList")
        public String addMusicList(String name, HttpSession session) {
            UserDTO user = (UserDTO) session.getAttribute("user");
            musicService.insertMusicList(user.getId(),name);
            return "redirect:/myMusic";
    }

    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< 删除歌单 >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    @RequestMapping(value = "/deleteMusicList")
    public String deleteMusicList(String name, HttpSession session) {
        UserDTO user = (UserDTO) session.getAttribute("user");
        musicService.deleteMusicList(user.getId(),name);
        return "redirect:/myMusic";
    }

    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< 修改歌单 >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    @RequestMapping(value = "/alterMusicList")
    public String updateMusicList(String name,String id, HttpSession session) {
        UserDTO user = (UserDTO) session.getAttribute("user");
        musicService.updateMusicList(user.getId(),Integer.parseInt(id),name);
        return "redirect:/myMusic";
    }





}
