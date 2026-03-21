package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class studentService {

    ArrayList<Student> list = new ArrayList<>();

    //crud-create
    public void create(String name,int age){
        Student student = new Student(name,age);
        list.add(student);
    }

    //crud-read
    public Student getId(int id) {
        for (Student student : list) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null; // 找不到返回null
    }

    public ArrayList<Student> getAll(){
        return list;
    }

    //crud-delete
    public void delete(int id){
        list.removeIf(student -> student.getId() == id);
    }

}
