
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.forum.entity.User;
import com.forum.service.IMusicService;
import com.forum.service.IUserService;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


//获取配置类
@ContextConfiguration(locations = {"classpath:spring.xml"})
//规定写法
@RunWith(SpringJUnit4ClassRunner.class)
public class TestUser {
    //标记这是bean里面有的
    @Autowired
    private IUserService userService;

    //测试加密
    @Test
    public void test1(){
        String username = "admin";
        String password = "admin";

        //测试MD5加密
        String algorithmName = "MD5";//加密算法（算法名称）
        Object source = password;//加密的原文
        Object salt = ByteSource.Util.bytes(username);//盐值
        int hashIterations = 2;//迭代次数
        SimpleHash hash = new SimpleHash(algorithmName, source, salt, hashIterations);
        System.out.println(hash);


        User user = userService.getOne(new QueryWrapper<User>()
                .eq("username", username)
                .eq("password", hash.toString()));
        System.out.println(user);
    }

    //测试注册
    @Test
    public void test2(){
        boolean register = userService.register("tom", "123", "123", "汤姆", "男");
        System.out.println(register);
    }

    //测试正则
    @Test
    public void test3(){
        System.out.println("abc123456".matches("^[a-z0-9_-]{3,16}$"));
    }


    //查询粉丝和我关注的用户
    @Test
    public void test4(){
        userService.attention(1).forEach(System.out::println);
        userService.fans(1).forEach(System.out::println);
    }
}
