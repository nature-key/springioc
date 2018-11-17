package com.itserver.day1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service(value = "userService")
public class UserService {
    //    @Autowired
//    private UserDao userDao;
    @Resource(name = "userDao")
    private UserDao userDao;

    public void add() {
        System.out.println("add.....service");
        userDao.add();
    }
}
