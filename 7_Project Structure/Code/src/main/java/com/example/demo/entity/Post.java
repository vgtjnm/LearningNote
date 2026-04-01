package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("post")
public class Post {
    private Long id;
    private String title;
    private String content;
    private String author;
    private LocalDateTime createTime;
}