package com.liuming.spring.tx;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @Author: 刘艳明
 * @Date: 19-5-15 下午5:25
 */
public class SpringTransactionTest {
    private ApplicationContext context = null;
    private BookShopDao bookShopDao = null;
    private BookShopService bookShopService = null;
    private Cashier cashier = null;

    {
        context = new ClassPathXmlApplicationContext("db.xml");
        bookShopDao = context.getBean(BookShopDao.class);
        bookShopService = context.getBean(BookShopService.class);
        cashier = context.getBean(Cashier.class);
    }

    @Test
    public void testTxPropagation(){
        //买多本
        cashier.checkout("jack", Arrays.asList("1001", "1002", "1003"));
    }

    @Test
    public void testBookShopServiceImpl(){
        bookShopService.purchase("jack", "1001");
    }


    @Test
    public void testFindBookPriceIsbn(){
        System.out.println(bookShopDao.findBookPriceIsbn("1001"));
    }
    @Test
    public void testUpdateBookStore(){
        bookShopDao.updateBookStore("1001");
    }
    @Test
    public void testUpdateUserAccount(){
        bookShopDao.updateUserAccount("jack", 100);
    }
}
