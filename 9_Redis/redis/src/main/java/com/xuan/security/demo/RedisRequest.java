package com.xuan.security.demo;

import lombok.Data;

@Data
public class RedisRequest {
    private String key;
    private String value;
}