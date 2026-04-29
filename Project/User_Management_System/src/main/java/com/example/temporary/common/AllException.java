package com.example.temporary.common;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AllException {

    @ExceptionHandler(BusinessException.class)
    public Result<?> catchBusiness(BusinessException b){
        return ResultUtils.error(b.getCode(),b.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public <T> Result<T> catchException(Exception e){
        return ResultUtils.error(500,e.getMessage());
    }

}
