package com.itserver.day1;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component(value = "user")
@Scope(value = "prototype")
public class User {

    private String name;
    public void test(){
        System.out.println("test....");
    }
}
