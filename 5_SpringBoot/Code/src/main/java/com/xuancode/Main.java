package com.xuancode;

//终于要来学习SpringBoot3了吗
//而且首先见到的就是java的包结构，上一次见到还是在flask


// ========== Spring Boot 内嵌Web服务器 ==========
//
// 1. Tomcat 是什么
//    - 全称 Apache Tomcat，免费开源
//    - 本质是一个 Java HTTP Web服务器 + 内嵌Servlet容器
//    - 负责监听端口、接收请求、返回响应
//
// 2. Spring Boot 的运行机制
//    - 每个 Spring Boot 应用自带内嵌Web服务器（无需额外部署）
//    - 默认监听端口：8080
//    - 应用停止 → 服务器停止 → 端口不再响应
//
// 3. 常见的内嵌Web服务器（三选一）
//    - Tomcat   （默认，Apache出品）
//    - Jetty    （Eclipse基金会，支持HTTP/2、WebSocket）
//    - Undertow （轻量级，Red Hat出品）
//
// 4. HTTP 状态码（初步了解）
//    - 404 Not Found：服务器收到请求，但找不到对应资源
//    - "白标错误页" 是 Spring Boot 的默认兜底页面
//
// ===============================================

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

//好了那么首先我们要干的是告诉系统这是一个SpringBoard引用程序，
//那么就要使用注解@SpringBootApplication
//这个注释实际上是三个注释的结合，添加配置，启用自动配置，添加组件扫描
//@SpringBootApplication等于下面三个东西
//@ComponentScan(basePackages = "com.xuancode")
//@EnableAutoConfiguration
//@Configuration
@SpringBootApplication
@RestController
@RequestMapping("api/v1/customers")
public class Main {

    private final CustomerRepository customerRepository;

    public Main(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public static void main(String[] args){
        SpringApplication.run(Main.class, args);//flask run!!!
    }

    @GetMapping
    public List<Customer> getCustomer() {
        return customerRepository.findAll();
    }

    record NewCustomerRequest (
            String name,
            String email,
            Integer age
    ) {

    }

    @PostMapping
    public void addCustomer(@RequestBody NewCustomerRequest request){
        Customer customer = new Customer();
        customer.setName(request.name);
        customer.setAge(request.age);
        customer.setEmail(request.email);
        customerRepository.save(customer);//这步是SQL语句INSERT或者UPDATE
    }

    @DeleteMapping("{customerId}")
    public void deleteCustomer(@PathVariable("customerId") Integer id) {
        customerRepository.deleteById(id);
    }

}

//这个东西类似flask的路由
//注解的话有Get,Post,Put,后面都有Mapping
//    @GetMapping("/greet")
//    public GreetResponse greet() {
//        GreetResponse response = new GreetResponse(
//                "Hello",
//                List.of("Java", "Golang", "Javascript"),
//                new Person("Alex",28, 30_000)
//        );
//        return response;
//    }
//
//
//    record Person (String name, int age, double savings){
//
//    }
//    record GreetResponse(
//            String greet,
//            List<String> favProgrammingLanguages,
//            Person person
//    ){}

//这个东西跟JSON有关系，作为后端我们的工作就是返回JSON
//record GreetResponse(String greet){}

//下面我们用类去展示一下它的等效形式
//    class GreetResponse {
//        private final String greet;
//
//        GreetResponse(String greet){
//            this.greet = greet;
//        }
//
//        public String getGreet() {
//            return greet;
//        }
//
//        @Override
//        public String toString() {
//            return "GreetResponse{" +
//                    "great='" + greet + '\'' +
//                    '}';
//        }
//
//        @Override
//        public boolean equals(Object o){
//            if(this == o) return true;
//            if(o == null || getClass() != o.getClass()) return false;
//            GreetResponse that = (GreetResponse) o;
//            return Object.equals(greet, that.greet);
//        }
//    }
//没错这两个代码几乎是等价的，所以我们写record就行了，而且record一般来说更简洁且正确
