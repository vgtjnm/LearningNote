package com.example.demo.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PostVO {
    private Long id;
    private String title;
    private String author;
    private LocalDateTime createTime;
    // 注意：没有 content，演示VO可以按需裁剪字段
}
