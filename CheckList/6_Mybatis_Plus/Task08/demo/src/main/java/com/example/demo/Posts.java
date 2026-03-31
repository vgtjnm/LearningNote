package com.example.demo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName()
public class Posts {

    @TableId(type = IdType.AUTO)
    private long id;
    private String title;
    private String content;
    private String author;

    private LocalDateTime createTime;

    @TableLogic
    private int deleted;

}
