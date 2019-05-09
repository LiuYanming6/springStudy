package com.liuming.spring.autowire;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: 刘艳明
 * @Date: 19-5-9 上午10:56
 */
public class Main {
    public static void main(String[] args) {
        //默认单例一开始就创建对象
        ApplicationContext context = new ClassPathXmlApplicationContext("beansAutowire.xml");
        Person person = (Person) context.getBean("p1");
        System.out.println(person);

        Person p1 = (Person) context.getBean("p2");
        Person p2 = (Person) context.getBean("p2");
        System.out.println(p1 == p2);//true

        //非单例 get时创建
        Car c1 = (Car) context.getBean("cars");
        Car c2 = (Car) context.getBean("cars");
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c1 == c2);//false
    }
}
