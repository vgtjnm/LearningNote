package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class Controller {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public void sendOrder(@RequestParam String item){
        orderService.placeOrder(item);
    }

}
