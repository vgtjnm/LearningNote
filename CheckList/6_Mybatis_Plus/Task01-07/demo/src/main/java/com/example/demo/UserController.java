package com.example.demo;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/users/search")
    public List<User> search(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Integer minAge,
            @RequestParam(required = false) Integer maxAge
    ) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        if(name != null) queryWrapper.like("name",name);
        if(minAge != null) queryWrapper.ge("age",minAge);
        if(maxAge != null) queryWrapper.le("age",maxAge);
        return userMapper.selectList(queryWrapper);
    }

    @GetMapping("/users/older-than")
    public List<User> olderThan(@RequestParam Integer age) {
        return userMapper.selectOlderThan(age);
    }

    @GetMapping("/users/advanced")
    public List<User> selectAdvanced(
            @RequestParam String name,
            @RequestParam Integer age
    ) {
        return userMapper.selectAdvanced(name,age);
    }

    @GetMapping("/users/{user_id}")
    public User selectById(@PathVariable int user_id) {
       return userMapper.selectById(user_id);
    }

    @DeleteMapping("/users/{user_id}")
    public void deleteById(@PathVariable int user_id) {
        userMapper.deleteById(user_id);
    }

    @PostMapping("/users/create")
    public void createUser(
            @RequestBody String name,
            @RequestBody int age,
            @RequestBody String email
    ) {
       User user = new User();
       user.setName(name);
       user.setAge(age);
       user.setEmail(email);
       userMapper.insert(user);
    }

    @GetMapping("/users/page")
    public Page<User> selectPage(
            @RequestParam long page,
            @RequestParam long size,
            @RequestParam(required = false) String name
    ) {
        Page<User> pageController = new Page<>();
        pageController.setCurrent(page);
        pageController.setSize(size);
        LambdaQueryWrapper<User> condition = new LambdaQueryWrapper<>();
        if(name != null && !name.isEmpty()) {
            condition.like(User::getName,name);
        }
        userMapper.selectPage(pageController,condition);
        return pageController;
    }

}
