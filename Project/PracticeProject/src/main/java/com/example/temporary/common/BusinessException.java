package com.example.temporary.common;

import lombok.Data;

@Data
public class BusinessException extends RuntimeException{

    private int code;
    //父类RuntimeException已经有message了，直接super

    public BusinessException(int code, String message){
        super(message);
        this.code=code;
    }

}
