package com.example.temporary.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class User {

    @TableId(type = IdType.ASSIGN_ID)
    private Long id;//Long可以为NULL

    private String username;
    private String password;
    private LocalDateTime createTime;


}
