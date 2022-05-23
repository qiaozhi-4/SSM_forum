package com.forum.dto;

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
    
    // User转UserDTO的静态【工厂】方法
    public static UserDTO fromUser(User user)
    {
        return new UserDTO(user.getId(), user.getUsername());
    }
}
