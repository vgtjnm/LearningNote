package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public List<User> list() {
        return userService.listAll();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable Long id) {
        return userService.getById(id);
    }

    @PostMapping
    public String save(@RequestBody User user) {
        userService.save(user);
        return "ok";
    }

    @DeleteMapping("/{id}")
    public String remove(@PathVariable Long id) {
        userService.remove(id);
        return "ok";
    }
}