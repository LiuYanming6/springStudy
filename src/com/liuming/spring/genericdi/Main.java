package com.liuming.spring.genericdi;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: 刘艳明
 * @Date: 19-5-13 上午9:21
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("genericdi.xml");

        UserService service = (UserService) context.getBean("userService");
        service.add();
    }
}
