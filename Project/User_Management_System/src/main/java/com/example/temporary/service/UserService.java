package com.example.temporary.service;

import com.example.temporary.entity.User;

public interface UserService {

    public void create(User user);
    public User read(Long id);
    public void update(User user);
    public void delete(Long id);

}
