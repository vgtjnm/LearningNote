package com.xuan.security.demo;


import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/demo-controller")
public class DemoController {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @GetMapping
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("Hello from secured endpoint");
    }


    //String是最简单的结构，存一个key对应一个值。
    //在SpringBoot里操作String用的是：
    //javaredisTemplate.opsForValue()
    //最常用的两个方法：
    //
    //opsForValue().set(key, value) — 存值
    //opsForValue().get(key) — 取值
    //
    //例子：
    //javaredisTemplate.opsForValue().set("city", "guangzhou");
    //String city = (String) redisTemplate.opsForValue().get("city");

    @PostMapping("/redis")
    public String redisCreate(@RequestBody RedisRequest request) {
        redisTemplate.opsForValue().set(request.getKey(),request.getValue());
        String str = redisTemplate.opsForValue().get(request.getKey());
        return str;
    }

}
