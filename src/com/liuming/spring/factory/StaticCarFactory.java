package com.liuming.spring.factory;

import com.liuming.spring.autowire.Car;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: 刘艳明
 * @Date: 19-5-12 下午1:02
 */
public class StaticCarFactory {
    private static Map<String, Car> cars = new HashMap<>();
    static {
        cars.put("audi", new Car("audi", 300000));
        cars.put("ford", new Car("ford", 150000));
    }
    /*
    静态工厂方法
     */
    public static Car getCar(String name){
        return cars.get(name);
    }
}
