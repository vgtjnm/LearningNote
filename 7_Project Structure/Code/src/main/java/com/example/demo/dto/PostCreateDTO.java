package com.example.demo.dto;

import lombok.Data;

@Data
public class PostCreateDTO {
    private String title;
    private String content;
    private String author;
}
