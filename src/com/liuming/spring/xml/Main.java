package com.liuming.spring.xml;

import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.impl.SimpleLog;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: 刘艳明
 * @Date: 19-5-8 下午5:29
 */
public class Main {
    public static void main(String[] args) {
        final SimpleLog logger = (SimpleLog) LogFactory.getLog(Class.class);
        logger.setLevel(SimpleLog.LOG_LEVEL_ALL);

//        HelloWorld helloWorld = new HelloWorld();
//        helloWorld.setName("liu");
//        hello.sayHello();

        // 1. 创建Spring的IOC容器对象
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 2. 从IOC容器中获取Bean实例
        HelloWorld hello = ctx.getBean(HelloWorld.class);
        hello.setName("new liu");
        hello.sayHello();

        Car car1 = (Car) ctx.getBean("car1");
        System.out.println(car1);
        Car car2 = (Car) ctx.getBean("car2");
        System.out.println(car2);

        Person p = ctx.getBean(Person.class);
        System.out.println(p);
    }
}
