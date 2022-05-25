
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
}
