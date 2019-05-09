package com.liuming.spring.xml;

/**
 * @Author: 刘艳明
 * @Date: 19-5-8 下午5:28
 */
public class HelloWorld {

    private String name;

    public HelloWorld() {
        System.out.println("HelloWorld construct");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void sayHello(){
        System.out.println("Hello, " + getName());
    }
}
