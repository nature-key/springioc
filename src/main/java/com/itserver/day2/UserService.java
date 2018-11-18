package com.itserver.day2;

import javax.annotation.Resource;

public class UserService {
    @Resource(name = "orderDao")
    private OrderDao orderDao;
    @Resource(name = "bookDao")
    private BookDao bookDao;

    public void test(){
        System.out.println("service.....");
        orderDao.buy();
        bookDao.book();
    }
}
