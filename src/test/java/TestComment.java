
import com.forum.service.IMusicService;
import com.github.pagehelper.PageHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


//获取配置类
@ContextConfiguration(locations = {"classpath:spring.xml"})
//规定写法
@RunWith(SpringJUnit4ClassRunner.class)
public class TestComment {
    @Autowired
    private IMusicService musicService;

    //分页查询音乐
    @Test
    public void test1(){
        PageHelper.startPage(2,5);//使用分页，查询第二页，每页5条
        musicService.list().forEach(System.out::println);
    }
}
