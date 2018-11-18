package com.itserver.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyBook {

    public void before(){
        System.out.println("before 前置通知");
    }
    public void after(){
        System.out.println("after 后置通知");
    }
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        System.out.println("环绕通知之前");
        proceedingJoinPoint.proceed();
        System.out.println("环绕通知之前");
    }
}
