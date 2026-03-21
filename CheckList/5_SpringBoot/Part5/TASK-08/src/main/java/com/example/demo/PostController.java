package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    record post(String title, String body){}

    //crud-create
    @PostMapping
    public void add(@RequestBody post p){
        postService.add(p.title(),p.body());
    }

    //crud-read
    @GetMapping
    public ArrayList<Post> getAll(){
        return postService.getAll();
    }

    @GetMapping("/{userId}")
    public Post getId(@PathVariable int userId){
        return postService.getId(userId);
    }

    record update(int id, String title, String body){}

    //crud-update
    @PutMapping
    public void upDate(@RequestBody update u){
        postService.update(u.id(),u.title(),u.body());
    }

    //crud-delete
    @DeleteMapping("/{userId}")
    public void delete(@PathVariable int userId){
        postService.delete(userId);
    }

}
