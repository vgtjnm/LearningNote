package com.example.temporary.service;

import com.example.temporary.dto.UserCreateDTO;
import com.example.temporary.dto.UserUpdateDTO;
import com.example.temporary.vo.UserReadVO;

public interface UserService {

    public Long create(UserCreateDTO user);
    public UserReadVO read(Long id);
    public void update(UserUpdateDTO user);
    public void delete(Long id);

}
