package com.liuming.spring.aop;

import org.springframework.stereotype.Component;

/**
 * @Author: 刘艳明
 * @Date: 19-5-14 上午9:19
 */

@Component
public class MyCalculator implements ICalculator {
    @Override
    public int add(int i, int j) {
        int result = i + j;
//        int a = 1/0;
        return result;
    }

    @Override
    public int sub(int i, int j) {
        int result = i - j;
        return result;
    }
}
