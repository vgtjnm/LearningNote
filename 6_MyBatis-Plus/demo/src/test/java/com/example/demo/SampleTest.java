package com.example.demo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Assert;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.User;
import com.example.demo.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class SampleTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        Assert.isTrue(5 == userList.size(), "");
        userList.forEach(System.out::println);
    }

    @Test
    public void testSelectById() {
        User user = userMapper.selectById(1L);
        System.out.println(user);
    }

    @Test
    public void testInsert() {
        User newUser = new User();
        newUser.setId(6L);
        newUser.setName("测试用户");
        newUser.setAge(20);
        newUser.setEmail("test6@test.com");
        userMapper.insert(newUser);
    }

    @Test
    public void testDelete() {
        userMapper.deleteById(6L);
    }

    @Test
    public void testWrapper() {
        //新建一个条件构造器对象，User表示条件是针对User表的
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //在条件里加一个等于条件，意思是WHERE name = 'Jone'
        queryWrapper.eq("name", "Jone");
        //把条件传给userMapper去数据库查，查出来的结果是一个User列表，存进userList里。
        List<User> userList = userMapper.selectList(queryWrapper);
        //把列表里每一条数据打印出来，forEach就是遍历，System.out::println就是打印。
        userList.forEach(System.out::println);
    }

    @Test
    public void MoreWrapper() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //条件构造器可以有多个条件，直接链式调用就行，多个条件默认是AND关系
        queryWrapper.eq("name","Jone").gt("age",17).
                like("name","o").lt("age",30);
        List<User> userList = userMapper.selectList(queryWrapper);
        userList.forEach(System.out::println);
    }

    @Test
    public void testPage() {
        Page<User> page = new Page<>(1, 2); // 第1页，每页2条
        Page<User> result = userMapper.selectPage(page, null);
        System.out.println("总条数：" + result.getTotal());
        System.out.println("当前页数据：");
        result.getRecords().forEach(System.out::println);
    }

    @Test
    public void testSelectByName() {
        List<User> userList = userMapper.selectByName("J");
        userList.forEach(System.out::println);
    }

}