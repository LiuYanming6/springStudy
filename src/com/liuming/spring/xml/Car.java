package com.liuming.spring.xml;

/**
 * @Author: 刘艳明
 * @Date: 19-5-8 下午9:23
 */
public class Car {
    private String city;
    private String color;
    private double price;

    public Car(String city, String color) {
        this.city = city;
        this.color = color;
    }

    public Car(String city, double price) {
        this.city = city;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "city='" + city + '\'' +
                '}';
    }
}
