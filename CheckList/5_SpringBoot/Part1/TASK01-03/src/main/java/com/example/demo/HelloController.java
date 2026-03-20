package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String Hello(@RequestParam String name){
        return "你好，" + name + "！欢迎使用SpringBoot。";
    }


//    放在同一个包是对的。
//    @ComponentScan 默认扫描主启动类所在包及其子包，所以你的 Controller 必须和主启动类在同一个包或者子包里，否则 Spring 找不到它。

//    什么时候用 URL 参数，什么时候用 Body，规律是这样的：
//
//    GET / DELETE → 参数放 URL，用 @RequestParam 或 @PathVariable 接
//    POST / PUT → 数据放 Body， 用 @RequestBody 接

}
