package com.liuming.spring.autowire;

import com.liuming.spring.autowire.Car;

/**
 * @Author: 刘艳明
 * @Date: 19-5-9 上午10:24
 */
public class Person {
    private String name;
    private Address address;
    private Car car;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
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
                ", address=" + address.toString() +
                ", car=" + car.toString() +
                '}';
    }

    private void finish() {
        System.out.println("finish Person");
    }

    private void init() {
        System.out.println("init Person");
    }
}
