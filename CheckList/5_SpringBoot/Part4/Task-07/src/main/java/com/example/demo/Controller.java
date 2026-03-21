package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/student")
public class Controller {

    @Autowired
    private studentService studentService;

    record s(String name,int age){}

    //crud-create
    @PostMapping
    public void create(@RequestBody s c){
        studentService.create(c.name(), c.age());
    }

    //crud-read
    @GetMapping
    public ArrayList<Student> getAll(){
        return studentService.getAll();
    }

    @GetMapping("/{studentId}")
    public Student getId(@PathVariable int studentId){
        return studentService.getId(studentId);
    }

    //crud-delete
    @DeleteMapping
    public void delte(@RequestParam int id){
        studentService.delete(id);
    }

}