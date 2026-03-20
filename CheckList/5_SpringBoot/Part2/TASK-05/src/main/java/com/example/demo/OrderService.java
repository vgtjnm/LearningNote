package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService extends NotificationService{

    @Autowired
    private NotificationService notificationService;

    public void placeOrder(String item){
        notificationService.send("订单已创建："+item);
    }

}
