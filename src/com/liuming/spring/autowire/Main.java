package com.liuming.spring.autowire;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @Author: 刘艳明
 * @Date: 19-5-9 上午10:56
 */
public class Main {
    public static void main(String[] args) {

        try {
            dataSource();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        spEl();
    }
    public static void spEl(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beansAutowire.xml");
        Car car = (Car) context.getBean("carSpEL");
        System.out.println(car);

        Person p3 = (Person) context.getBean("p3");
        System.out.println(p3);
    }
    public static void test() {
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

    private static void dataSource() throws SQLException {
        ApplicationContext context = new ClassPathXmlApplicationContext("db.xml");
//        DataSource source = (DataSource) context.getBean("dataSource");
        DriverManagerDataSource source = (DriverManagerDataSource) context.getBean("dataSource");

        System.out.println(source.getUsername() + "," + source.getPassword() + "," + source.getUrl());
//        System.out.println(source.getConnection("root", "root"));//right

        /* debug 发现 用户名=liu 密码="/home/liu/IdeaProjects/springStudy"
        finishBeanFactoryInitialization(beanFactory) --> preInstantiateSingletons
*/
             System.out.println(source.getConnection());
    }
}
