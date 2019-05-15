package com.liuming.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: 刘艳明
 * @Date: 19-5-14 上午9:19
 */
public class Main {
    public static void main(String[] args) {
//        testProxy();
        testAop();
    }

    public static void testAop() {
        ApplicationContext context = new ClassPathXmlApplicationContext("aop.xml");
        ICalculator calculator = context.getBean(ICalculator.class);
        int result = calculator.add(3,3);
        System.out.println("------->" + result);


        result = calculator.sub(3,3);
        System.out.println("------->" + result);
    }
    public static void testProxy() {
        ICalculator calculator = new MyCalculator();
        ICalculator proxy = new MyCalculatorLogProxy(calculator).getLogProxy();
        int result = proxy.add(1,2);
        System.out.println("------->" + result);
        result = proxy.sub(1,2);
        System.out.println("------->" + result);


        System.out.println(calculator.getClass().getName());//com.liuming.spring.aop.MyCalculator
        System.out.println(proxy.getClass().getName());//com.sun.proxy.$Proxy0
    }
}
