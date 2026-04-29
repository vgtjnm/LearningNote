package com.example.temporary.service.impl;

import com.example.temporary.common.BusinessException;
import com.example.temporary.mapper.UserMapper;
import com.example.temporary.service.UserService;
import com.example.temporary.entity.User;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    //这个方法是一个构造方法作用只有一个：
    //在创建对象的时候，把依赖传进来

    //你之前习惯的是：
    //@Autowired
    //UserMapper userMapper;
    //你可以把它想成“初始化时喂数据”
    //👉 相当于：
    //“Spring帮你偷偷塞进去”

    //而现在这个写法是：
    //public UserServiceImpl(UserMapper userMapper)
    //👉 相当于：
    //“你创建这个类的时候，必须把 userMapper 给我”

    //this.userMapper = userMapper; 是啥意思？
    //拆开看：
    //this.userMapper = userMapper;
    //👉 左边：
    //this.userMapper = 当前这个对象里的成员变量
    //👉 右边：
    //userMapper = 构造方法传进来的参数
    //👉 整句话意思就是：
    //🔥 把“外面传进来的 mapper”赋值给“我自己内部的 mapper”

    @Override
    public void create(User user){

        if (user == null || user.getUsername() == null || user.getUsername().trim().isEmpty()) {
            throw new BusinessException(400, "用户名不能为空");
        }

        user.setId(null);
        user.setCreateTime(LocalDateTime.now());

        try{
            userMapper.insert(user);
        }
        catch (DuplicateKeyException e){
            throw new BusinessException(409,"用户已存在");
        }

    }

    @Override
    public User read(Long id){

        if(id <= 0)
            throw new BusinessException(400,"id错误");

        //MyBatis-Plus 的 selectById：
        //userMapper.selectById(id)
        //它的行为是：
        //情况	行为
        //查到数据	返回 User
        //查不到	返回 null
        //SQL异常	抛运行时异常

        User user = userMapper.selectById(id);

        if(user == null){
            throw new BusinessException(404,"用户不存在");
        }

        return user;

    }

    @Override
    public void update(User user){

        if (user == null || user.getUsername() == null || user.getUsername().trim().isEmpty()) {
            throw new BusinessException(400, "用户名不能为空");
        }

        int rows = userMapper.updateById(user);

        if(rows <= 0){
            throw new BusinessException(400,"用户修改失败");
        }

    }

    @Override
    public void delete(Long id){

        if(id<=0)
            throw new BusinessException(400,"id错误");

        int rows = userMapper.deleteById(id);

        if(rows<=0){
            throw new BusinessException(400,"用户删除失败");
        }

    }

}
