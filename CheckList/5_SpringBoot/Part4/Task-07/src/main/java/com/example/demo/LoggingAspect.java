package com.example.demo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {

    // 切点：拦截所有Controller包下的所有方法
    @Around("execution(* com.example.demo.*Controller.*(..))")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {

        // 获取方法名
        String methodName = joinPoint.getSignature().getName();

        // 获取参数
        Object[] args = joinPoint.getArgs();

        // 获取当前时间（回答你问题1）
        long startTime = System.currentTimeMillis();

        System.out.println("[" + startTime + "] 调用接口：" + methodName + "，参数：" + Arrays.toString(args));

        // 执行真正的方法
        Object result = joinPoint.proceed();

        // 耗时 = 结束时间 - 开始时间
        long cost = System.currentTimeMillis() - startTime;

        System.out.println("[" + System.currentTimeMillis() + "] 接口返回：" + result + "，耗时：" + cost + "ms");

        return result;
    }
}