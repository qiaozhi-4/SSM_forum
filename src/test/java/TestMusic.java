
import com.forum.service.IMusicService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


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
        musicService.findByUserId(1,"我喜欢的音乐", 2).forEach(System.out::println);
    }
}
