package com.forum.entity;

import com.alibaba.druid.sql.visitor.functions.Char;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.baomidou.mybatisplus.annotation.IdType.AUTO;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("reply")
public class Topic {
    @TableId(type = AUTO)
    private Integer id;
//    @TableField("topiccaption")
    private String topiccaption;
//    @TableField("content")
    private String content;
    @TableField("plate_id")
    private Integer plateId;
    @TableField("member_id")
    private Integer memberId;
//    @TableField("istop")
    private Byte istop;
//    @TableField("isgood")
    private Byte isgood;
//    @TableField("notused")
    private Byte notused;
//    @TableField("date")
    private String date;
//    @TableField("click")
    private Integer click;
//    @TableField("replycount")
    private Integer replycount;
//    @TableField("lastreplyuser")
    private String lastreplyuser;
//    @TableField("lastreplydate")
    private String lastreplydate;
}
