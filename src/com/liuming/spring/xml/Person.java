package com.liuming.spring.xml;

/**
 * @Author: 刘艳明
 * @Date: 19-5-8 下午9:40
 */
public class Person {
    private String name;
    private Car car;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", car=" + car.toString() +
                '}';
    }
}
