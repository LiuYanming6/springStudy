package com.liuming.spring.genericdi;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: 刘艳明
 * @Date: 19-5-13 上午9:17
 */
public class BaseService <T>{

    @Autowired
    BaseRepository<T> repository;

    public void add(){
        System.out.println("add in BaseService" + repository);
    }
}
