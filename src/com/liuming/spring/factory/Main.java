package com.liuming.spring.factory;

import com.liuming.spring.autowire.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: 刘艳明
 * @Date: 19-5-12 下午1:09
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("factory.xml");
        Car car1 = (Car) context.getBean("car1");
        System.out.println(car1);

        Car car2 = (Car) context.getBean("car2");
        System.out.println(car2);

        Car car3 = (Car) context.getBean("car3");
        System.out.println(car3);
    }
}
