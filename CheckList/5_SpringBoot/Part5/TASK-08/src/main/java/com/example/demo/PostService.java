package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PostService {

    ArrayList<Post> posts = new ArrayList<>();

    //crud-create
    public void add(String title, String body){
        Post post = new Post(title, body);
        posts.add(post);
    }

    //crud-read
    public ArrayList<Post> getAll(){
        return posts;
    }

    public Post getId(int id){
        for(Post post:posts){
            if(post.getId() == id)
                return post;
        }
        return null;
    }

    //crud-update
    public void update(int id, String title, String body){
        for(Post post:posts){
            if(post.getId()==id){
                post.setTitle(title);
                post.setBody(body);
            }
        }
    }

    //crud-delete
    public void delete(int id){
        posts.removeIf(post -> post.getId()==id);
    }

}
