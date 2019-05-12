package com.liuming.spring.anotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: 刘艳明
 * @Date: 19-5-12 下午2:17
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("---------test anotation--------------");
        ApplicationContext context = new ClassPathXmlApplicationContext("anotation.xml");

        TestAnotation testAnotation = (TestAnotation) context.getBean("testAnotation");
        testAnotation.sayHi();
    }
}
