package com.example.demo;

import java.util.List;

public interface UserService {
    List<User> listAll();
    User getById(Long id);
    void save(User user);
    void remove(Long id);
}