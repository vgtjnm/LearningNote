package com.example.demo;

public class Student {

    static private int ids = 0;
    private int id;
    private String name;
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    Student(String name, int age){
        id = ++ids;
        this.name = name;
        this.age = age;
    }



}
