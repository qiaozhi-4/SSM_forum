package com.forum.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.baomidou.mybatisplus.annotation.IdType.AUTO;

//自动生成get/set/toString
@Data
//自动生成全参构造函数
@AllArgsConstructor
//自动生成无参构造函数
@NoArgsConstructor
//标记是这个表
@TableName("member")
public class Member {
    @TableId(value = "member_id", type = AUTO)
    private Integer memberId;
    @TableField("member_name")
    private String memberName;
    @TableField("member_pwd")
    private String memberPwd;
    @TableField("member_url")
    private String memberUrl;
    @TableField("member_real_name")
    private String memberRealName;
    @TableField("signature")
    private String signature;
    @TableField("qq")
    private String qq;
    @TableField("isadmin")
    private Byte isadmin;
    @TableField("ispower")
    private Byte ispower;
    @TableField("mark")
    private Integer mark;
    @TableField("action")
    private Byte action;
    @TableField("topiccount")
    private Integer topiccount;
    @TableField("replycount")
    private Integer replycount;
    @TableField("date")
    private String date;
    @TableField("notused")
    private Byte notused;
    @TableField("lastvist")
    private String lastvist;
}
