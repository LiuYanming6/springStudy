package com.liuming.spring.autowire;

/**
 * @Author: 刘艳明
 * @Date: 19-5-9 上午10:27
 */
public class Car {
    private static int count = 0;
    private String brand;
    private double price;
    private double wheelSize;//轮胎周长

    public Car() {
        count++;
        System.out.println("创建car" + count);
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }


    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Car.count = count;
    }

    public double getWheelSize() {
        return wheelSize;
    }

    public void setWheelSize(double wheelSize) {
        this.wheelSize = wheelSize;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                ", wheelSize=" + wheelSize +
                '}';
    }
}
