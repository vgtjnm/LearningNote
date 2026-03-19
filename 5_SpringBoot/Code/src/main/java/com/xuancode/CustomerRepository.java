package com.xuancode;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository
        extends JpaRepository<Customer, Integer> {

//    这个JpaRepository接口很重要，我来解释清楚。
//
//    `JpaRepository`是Spring Data JPA提供的一个接口，它的作用就是帮你把数据库的增删改查都写好了，你不需要自己写SQL。
//    你只需要这样写：
//
//    public interface CustomerRepository extends JpaRepository<Customer, Long> {
//    }
//    就这一行，你就自动拥有了这些方法：
//
//     - `findAll()` → `SELECT * FROM customer`
//     - `findById(id)` → `SELECT * FROM customer WHERE id = ?`
//     - `save(customer)` → INSERT 或 UPDATE
//     - `deleteById(id)` → `DELETE FROM customer WHERE id = ?`
//
//    一行SQL都不用写，JPA全帮你干了。
//
//    跟你学过的Flask对比理解：Flask里你要自己写`db.session.query()`或者手写SQL，Spring Boot里JpaRepository把这些全封装好了，你直接调方法就行。
//    JpaRepository的"<Customer, Integer>"里有两个参数
//    这两个是泛型参数，告诉JpaRepository两件事：
//    `Customer` → 你要操作的是哪张表，对应`Customer`这个实体类
//     `Integer` → 这张表的主键（id）是什么类型
//
//    所以`JpaRepository<Customer, Integer>`的意思就是：帮我操作customer表，这张表的id是Integer类型。
//
//    如果你的id是`Long`类型就写`JpaRepository<Customer, Long>`，换个实体类就写那个类名，就这么简单。
//
//    你可以把它理解成：我要操作谁，我的主键是什么类型。
//
//    这个是Spring Boot里很核心的东西，好好把这段看完。

}
