package com.liuming.spring.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: 刘艳明
 * @Date: 19-5-15 下午5:57
 */
@Service
public class BookShopShopServiceImpl implements BookShopService {

    @Autowired
    private BookShopDao bookShopDao;

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
