package com.example.demo;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

    @Autowired
    PostMapper postMapper;

    @GetMapping("/articles")
    public Page<Posts> selectPage(@RequestParam(required = false) String author) {
        Page<Posts> page = new Page<>();
        LambdaQueryWrapper<Posts> queryWrapper = new LambdaQueryWrapper<>();
        if(author != null && !author.isEmpty()){
            queryWrapper.like(Posts::getAuthor,author);
        }
        postMapper.selectPage(page,queryWrapper);
        return page;
    }

    @GetMapping("/articles/{post_id}")
    public Posts selectPage(@PathVariable long post_id) {
        return postMapper.selectAdvanced(post_id);
    }

    @PostMapping("/articles")
    public void createPost(
            @RequestBody Posts post_
    ) {
        postMapper.insert(post_);
    }

    @PutMapping("/articles/{post_id}")
    public void updatePost(
            @PathVariable int post_id,
            @RequestBody Posts posts
    ) {
        posts.setId(post_id);
        postMapper.updateById(posts);
    }

    @DeleteMapping("/articles/{post_id}")
    public void deletePost(@PathVariable int post_id){
        postMapper.deleteById(post_id);
    }


}
