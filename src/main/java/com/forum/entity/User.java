package com.forum.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//自动生成get/set/toString
@Data
//自动生成全参构造函数
@AllArgsConstructor
//自动生成无参构造函数
@NoArgsConstructor
//标记是这个表
@TableName("user1")
public class User {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    @TableField("username")
    @JsonProperty("name")//转json时的字段名
    private String username;
    @TableField("password")
    @JsonIgnore//转json时，忽略改字段
    private String password;
    @TableField("money")
    private Double money;
}
