package com.web.spring.service;

import com.web.spring.dao.UserDao;

public class UserService {


    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void add(){
        System.out.println("service.....");
        userDao.add();
    }
}
