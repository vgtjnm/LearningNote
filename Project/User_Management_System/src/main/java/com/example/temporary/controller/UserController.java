package com.example.temporary.controller;

import com.example.temporary.common.Result;
import com.example.temporary.common.ResultUtils;
import com.example.temporary.service.UserService;
import com.example.temporary.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/create")
    public Result<Long> create(@RequestBody User user){
        userService.create(user);
        return ResultUtils.success(user.getId());
    }

    @GetMapping("/read/{userid}")
    public Result<User> read(@PathVariable Long userid){
        User user = userService.read(userid);
        return ResultUtils.success(user);
    }

    @PostMapping("/update")
    public Result<String> update(@RequestBody User user){
        userService.update(user);
        return ResultUtils.success(null);
    }

    @PostMapping("/delete/{userid}")
    public Result<String> delete(@PathVariable Long userid){
        userService.delete(userid);
        return ResultUtils.success(null);
    }

}
