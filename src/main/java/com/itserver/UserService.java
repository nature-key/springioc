package com.itserver;

public class UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void test() {
        System.out.println("test.....");

        userDao.add();
    }
}
