
import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.forum.entity.Music;
import com.forum.entity.MusicList;
import com.forum.mapper.IMusicListMapper;
import com.forum.mapper.IMusicMapper;
import com.forum.mapper.IUserMapper;
import com.forum.service.IMusicService;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//获取配置类
@ContextConfiguration(locations = {"classpath:spring.xml"})
//规定写法
@RunWith(SpringJUnit4ClassRunner.class)
public class TestMusic {
    @Autowired
    private IMusicService musicService;
    @Autowired
    private IMusicListMapper musicListMapper;
    @Autowired
    private IMusicMapper musicMapper;


    //查询用户歌单里的歌曲
    @Test
    public void test1(){
        musicService.findByUserId(1,"我喜欢的音乐",8, 2).getList().forEach(System.out::println);
    }


    //测试查询用户歌单
    @Test
    public void test2(){
        musicService.findByUid(1).getList()
                .forEach(System.out::println);
    }

    //测试查询用户歌单歌曲
    @Test
    public void test3(){
        musicService.findByUserId(1,"我喜欢的音乐",1,4).getList()
                .forEach(System.out::println);
        long l = musicService.findByUserId(1, "我喜欢的音乐", 1, 4).getTotal();
        System.out.println(l);
    }

    //模糊查询
    @Test
    public void test4(){
        musicService.findByFuzzy("帅",1).getList().forEach(System.out::println);
    }

    //添加歌曲到歌单
    @Test
    public void test5(){
        System.out.println( musicService.insertUserMusicList(1,19));
    }

    //添加歌单
    @Test
    public void test6(){
        System.out.println( musicService.insertMusicList(1,"gg"));
    }

    //把歌曲移除歌单
    @Test
    public void test7(){
        System.out.println( musicService.deleteUserMusicList(1,19));
    }

    //删除歌单
    @Test
    public void test8(){
        System.out.println( musicService.deleteMusicList(1,"gg"));
    }

    @Test
    public void test9(){
        musicListMapper.updateById(new MusicList(1, null,null,"86"));
    }

    @Test
    public void test10(){

        //查询用户所有的歌单
        PageInfo<MusicList> musicLists = musicService.findByUid(1);
        Map<String, List<Music>> map = new HashMap<>();
        for (MusicList musicList : musicLists.getList()) {
            PageInfo<Music> musicPageInfo = musicService.findByUserId(1, musicList.getName(), musicList.getId(), 1);
            map.put(musicList.getName(),musicPageInfo.getList());
        }
        System.out.println(map);
        musicMapper.findByUserId(1, "我喜欢的音乐").forEach(System.out::println);

        musicListMapper.selectList(new QueryWrapper<MusicList>()
                .eq("user_id",1).eq("name","我喜欢的音乐"))
                .forEach(System.out::println);

    }
}
