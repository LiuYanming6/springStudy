package com.liuming.spring.tx;

/**
 * @Author: 刘艳明
 * @Date: 19-5-15 下午4:58
 */
public interface BookShopDao {
    //根据书号获取书的单价
    int findBookPriceIsbn(String isbn);

    //更新书的库存, 库存--
    void updateBookStore(String isbn);

    //更新用户的账户余额使username的balance - price
    void updateUserAccount(String username, int price);
}
