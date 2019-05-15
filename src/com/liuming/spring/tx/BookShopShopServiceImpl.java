package com.liuming.spring.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.

/**
 * @Author: 刘艳明
 * @Date: 19-5-15 下午5:57
 */
@Service
import org.springframework.transaction.annotation.Transactional;

public class BookShopShopServiceImpl implements BookShopService {

    @Autowired
    private BookShopDao bookShopDao;

    @Transactional
    @Override
    public void purchase(String username, String isbn) {
        // 1.获取书的单价
        int price = bookShopDao.findBookPriceIsbn(isbn);
        // 2.更新库存
        bookShopDao.updateBookStore(isbn);
        // 3.更新用户余额
        bookShopDao.updateUserAccount(username, price);
    }
}
