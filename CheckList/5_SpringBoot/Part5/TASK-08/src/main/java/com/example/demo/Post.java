package com.example.demo;

public class Post {

    static private int ids = 0;
    private int id;
    private String title;
    private String body;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    Post(String title, String body){
        this.id = ++ids;
        this.title = title;
        this.body = body;
    }



}
