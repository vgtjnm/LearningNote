package com.example.temporary.controller;

import com.example.temporary.common.Result;
import com.example.temporary.common.ResultUtils;
import com.example.temporary.dto.UserCreateDTO;
import com.example.temporary.dto.UserUpdateDTO;
import com.example.temporary.service.UserService;
import com.example.temporary.vo.UserCreateVO;
import com.example.temporary.vo.UserReadVO;
import com.example.temporary.vo.UserUpdateVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    //DTO和VO一般用来控制两个以上的复杂输入跟输出
    //如果返回或者获取只有一个数据，可以不用设计DTO，VO，不过度设计

    @PostMapping("/create")
    public Result<Long> create(@RequestBody UserCreateDTO user){
        Long id = userService.create(user);
        return ResultUtils.success(id);
    }

    @GetMapping("/read/{userid}")
    public Result<UserReadVO> read(@PathVariable Long userid){
        UserReadVO user = userService.read(userid);
        return ResultUtils.success(user);
    }

    @PostMapping("/update")
    public Result<String> update(@RequestBody UserUpdateDTO user){
        userService.update(user);
        return ResultUtils.success("update success!");
    }

    @PostMapping("/delete/{userid}")
    public Result<String> delete(@PathVariable Long userid){
        userService.delete(userid);
        return ResultUtils.success(null);
    }

}
