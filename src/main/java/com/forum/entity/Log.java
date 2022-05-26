package com.forum.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("log")
public class Log {
    @TableField("id")
    private Integer id;
    @TableField("username")
    private String username;
    @TableField("operateDesc")
    private String operateDesc;
    @TableField("ipAddress")
    private String ipAddress;
    @TableField("createTime")
    private String createTime;
}
