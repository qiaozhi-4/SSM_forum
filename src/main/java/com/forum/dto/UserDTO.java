package com.forum.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.forum.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
这是一个DTO，只需要保留合适的字段即可
使用JSON时发送到前端
 */
@Data @AllArgsConstructor @NoArgsConstructor
public class UserDTO
{
    private int id;
    private String username;
    private String name;
    private String url;
    private String info;
    private String sex;
    private String birthday;
    private String address;
    private Integer vip;
    private String date;
    
    // User转UserDTO的静态【工厂】方法
    public static UserDTO fromUser(User user)
    {
        return new UserDTO(user.getId(), user.getUsername(),user.getName(),user.getUrl(),
                user.getInfo(),user.getSex(),user.getBirthday(),user.getAddress(),
                user.getVip(),user.getDate());
    }
}
