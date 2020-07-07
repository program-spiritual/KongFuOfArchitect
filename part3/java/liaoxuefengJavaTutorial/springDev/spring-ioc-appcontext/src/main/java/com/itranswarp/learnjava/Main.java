package com.itranswarp.learnjava;

import com.itranswarp.learnjava.service.User;
import com.itranswarp.learnjava.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");

//      获取Bean:

        UserService userService = context.getBean(UserService.class);

//        // 正常调用:
        User user = userService.login("bob@example.com", "password");

        System.out.println(user.getName());
    }
}
