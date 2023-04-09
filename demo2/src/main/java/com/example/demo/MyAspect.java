package com.example.demo;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
public class MyAspect {

    @Around("execution(* com.example.demo.HpPrinter.*(..))")

    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        Date start = new Date();
        Object obj = pjp.proceed();
        Date end = new Date();
        long time = end.getTime() - start.getTime();
        System.out.println(" 總共執行了:" + time + " ms");
        return obj;
    }
    /*
    @Before("execution(* com.example.demo.HpPrinter.*(..))")
    public void before(){
        System.out.println("i am before");
    }
    @After("execution(* com.example.demo.HpPrinter.*(..))")
    public void after(){
        System.out.println("i am after");
    }
    */





/*
    @Around("execution(* com.example.demo.HpPrinter.*(..))")

    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println(" i am around before");
        //執行切入點方法
        Object obj=pjp.proceed();
        System.out.println("i am around agter");
        return obj;
    }

    */

}
