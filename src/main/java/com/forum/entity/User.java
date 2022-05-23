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
@TableName("user")
public class User {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    @TableField("username")
    private String username;
    @TableField("password")
    private String password;
    @TableField("name")
    private String name;
    @TableField("url")
    private String url;
    @TableField("info")
    private String info;
    @TableField("sex")
    private String sex;
    @TableField("birthday")
    private String birthday;
    @TableField("address")
    private String address;
    @TableField("vip")
    private Integer vip;
    @TableField("date")
    private String date;
}
