package com.tx;

public class OrderService {
    private  OrderDao orderDao;

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public void  account(){

        orderDao.lessMoney();
        orderDao.moreMoney();
    }
}

