package com.example.temporary.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserReadVO {

    private Long id;
    private String username;
    private LocalDateTime createTime;

}
