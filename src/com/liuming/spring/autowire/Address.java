package com.liuming.spring.autowire;

/**
 * @Author: 刘艳明
 * @Date: 19-5-9 上午10:26
 */
public class Address {
    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", street='" + street + '\'' +
                '}';
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    private String city;
    private String street;
}
