package com.forum.controller;

import com.forum.dto.UserDTO;
import com.forum.entity.Music;
import com.forum.entity.MusicList;
import com.forum.entity.User;
import com.forum.service.IMusicService;
import com.github.pagehelper.PageInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

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
        int page = 1;
        if (pageNum != null){
            page = Integer.parseInt(pageNum);
        }
        //拿到现在登录的用户
        UserDTO user = (UserDTO) session.getAttribute("user");
        //查询用户所有的歌单
        PageInfo<MusicList> musicLists = musicService.findByUid(user.getId());
        //查询用户现在点击的歌单的id
        MusicList list = musicService.findByNameAndUid(name,user.getId());
        //查询用户点击歌单里面的歌曲
        PageInfo<Music> musics = musicService.findByUserId(user.getId(), name, list.getId(), page);
        model.addAttribute("musicLists",musicLists.getList());
        model.addAttribute("musics",musics.getList());
        model.addAttribute("musicListsInfo",musicLists);
        model.addAttribute("musicsInfo",musics);
        return "myMusic";
    }

    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< 模糊搜索 >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    @RequestMapping(value = "/fuzzy")
    public String fuzzy(String str, String pageNum, Model model) {
        int page = 1;
        if (pageNum != null){
            page = Integer.parseInt(pageNum);
        }
        PageInfo<Music> musics = musicService.findByFuzzy(str, page);

        model.addAttribute("musics",musics.getList());
        model.addAttribute("musicsInfo",musics);
        return "fuzzy";
    }


}
