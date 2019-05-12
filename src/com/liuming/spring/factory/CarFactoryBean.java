package com.liuming.spring.factory;

import com.liuming.spring.autowire.Car;
import org.springframework.beans.factory.FactoryBean;

/**
 * @Author: 刘艳明
 * @Date: 19-5-12 下午1:35
 */
public class CarFactoryBean implements FactoryBean<Car> {

    private String brand;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public Car getObject() throws Exception {
        return new Car("别摸我", 500000);
    }

    @Override
    public Class<?> getObjectType() {
        return Car.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
