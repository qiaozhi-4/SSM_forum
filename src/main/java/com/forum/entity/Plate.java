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
@TableName("plate")
public class Plate {
    @TableId(type = AUTO)
    private Integer plateId;
    @TableField("plate_name")
    private String plateName;
//    @TableField("plateesc")
    private String plateesc;
//    @TableField("date")
    private String date;
//    @TableField("member")
    private String member;
    @TableField("image_url")
    private String imageUrl;
}
