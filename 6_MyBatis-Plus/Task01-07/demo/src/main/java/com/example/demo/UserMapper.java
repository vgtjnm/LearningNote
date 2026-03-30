package com.example.demo;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {
    @Select("SELECT * FROM `user` WHERE age > #{age}")
    List<User> selectOlderThan(@Param("age") Integer age);

    List<User> selectAdvanced(@Param("name") String name, @Param("age") Integer age);
}