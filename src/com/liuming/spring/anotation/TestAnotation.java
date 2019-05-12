package com.liuming.spring.anotation;

import org.springframework.stereotype.Repository;

/**
 * @Author: 刘艳明
 * @Date: 19-5-12 下午2:15
 */
//@Repository("abc")//context.getBean("abc");
@Repository
public class TestAnotation {
    public void sayHi(){
        System.out.println("Hi");
    }
}
