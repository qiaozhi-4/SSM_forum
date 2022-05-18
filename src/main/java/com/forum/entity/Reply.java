package com.forum.entity;

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
public class Reply {
    @TableId(type = AUTO)
    private Integer id;
//    @TableField("forumid")
    private Integer forumid;
//    @TableField("topicid")
    private Integer topicid;
//    @TableField("memberid")
    private Integer memberid;
//    @TableField("catption")
    private String catption;
//    @TableField("content")
    private String content;
//    @TableField("date")
    private String date;
//    @TableField("notused")
    private Byte notused;
}
