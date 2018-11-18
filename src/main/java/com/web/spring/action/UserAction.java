package com.web.spring.action;

import com.opensymphony.xwork2.ActionSupport;
import com.web.spring.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserAction extends ActionSupport {

    @Override
    public String execute() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean4.xml");
        UserService userService = (UserService) context.getBean("userService");
        userService.add();
        return NONE;
    }
}
