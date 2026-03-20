package com.example.demo;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/query")
    public String Query(@RequestParam String keyword){
        return "你的密码是："+keyword;
    }

    @GetMapping("/{userId}")
    public Long getId(@PathVariable Long userId){//名字需要和路由名一样
        return userId;
    }

    record UserDTO(
            String name,
            int age
    ){}

    @PostMapping("/create")
    public UserDTO getUser(@RequestBody UserDTO user){
        return user;
    }

}
