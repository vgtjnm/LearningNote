package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

//测试类会影响真实数据库，除非你配了专门的测试数据库或者加了事务回滚（@Transactional）。
//大多数人用测试类是为了测业务逻辑对不对，不是测数据库，测接口的话用Postman更直观。

@SpringBootTest
public class SampleTest {

    @Autowired
    private UserMapper userMapper;

    //#01
    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
    }

    //#02
    @Test
    public void testSelectAll() {
        System.out.println("test return all user");
        List<User> userList = userMapper.selectList(null);
        userList.forEach((System.out::println));
    }

    @Test
    public void testSelectId() {
        System.out.println("test return Id user");
        User user_1 = userMapper.selectById(1);
        System.out.println(user_1);
    }

    @Test
    public void testInsert() {
        System.out.println("test insert new user");
        User user = new User();
        user.setName("lory");
        user.setAge(12);
        user.setEmail("lory@123.com");
        int row = userMapper.insert(user);
        if (row > 0){
            System.out.println("insert successfully");
        }
        else{
            System.out.println("insert failed");
        }
    }

    @Test
    public void testUpdate() {
        System.out.println("test update user");
        User updateUser = new User();
        updateUser.setName("Dar");
        updateUser.setAge(111);
        updateUser.setEmail("Dar@123213.com");
        updateUser.setId(1L);
        int rows = userMapper.updateById(updateUser);
        if (rows > 0) {
            System.out.println("User updated successfully.");
        } else {
            System.out.println("No user updated.");
        }
    }

    @Test
    public void testDelete() {
        System.out.println("test delete user");
        int user_id = 1;
        int rows = userMapper.deleteById(user_id);
        if (rows > 0) {
            System.out.println("Users deleted successfully.");
        } else {
            System.out.println("No users deleted.");
        }
    }

}