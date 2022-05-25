
import com.alibaba.fastjson2.JSON;
import com.forum.entity.Music;
import com.forum.service.IMusicService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.nio.charset.StandardCharsets;
import java.util.List;


//获取配置类
@ContextConfiguration(locations = {"classpath:spring.xml"})
//规定写法
@RunWith(SpringJUnit4ClassRunner.class)
public class TestMusic {
    @Autowired
    private IMusicService musicService;

    //分页查询音乐
    @Test
    public void test1(){
        musicService.pageAll(2).forEach(System.out::println);
    }

    //查询用户歌单里的歌曲
    @Test
    public void test2(){
        musicService.findByUserId(1,"我喜欢的音乐",8, 2).forEach(System.out::println);
    }

    //测试json转换
    @Test
    public void test3(){
        List<Music> musics = musicService.pageAll(4);
        String s = JSON.toJSONString(musics);
        System.out.println(s);
        System.out.println("----------------------------------");
        JSON.parseObject(s, List.class).forEach(System.out::println);
    }

    //测试查询用户歌单
    @Test
    public void test4(){
        musicService.findByUid(1)
                .forEach(System.out::println);
    }

    //测试查询用户歌单歌曲
    @Test
    public void test5(){
        musicService.findByUserId(1,"我喜欢的音乐",1,4)
                .forEach(System.out::println);
    }
}
