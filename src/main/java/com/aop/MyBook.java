package com.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Value;

@Aspect
public class MyBook {
  @Before(value = "execution(* com.aop.Book.*(..))")
  public void before(){
      System.out.println("before.....");
  }
}

