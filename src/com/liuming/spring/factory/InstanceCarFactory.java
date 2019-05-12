package com.liuming.spring.factory;

import com.liuming.spring.autowire.Car;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: 刘艳明
 * @Date: 19-5-12 下午1:12
 */
public class InstanceCarFactory {
    private Map<String, Car> cars = null;

    public InstanceCarFactory() {
        cars = new HashMap<>();
        cars.put("audi", new Car("audi", 300000));
        cars.put("ford", new Car("ford", 150000));
    }

    /*
    实例工厂方法
     */
    public  Car getCar(String name){
        return cars.get(name);
    }
}
