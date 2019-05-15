package com.liuming.spring.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @Author: 刘艳明
 * @Date: 19-5-15 下午5:03
 */

@Repository
public class BookShopDaoImpl implements BookShopDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int findBookPriceIsbn(String isbn) {
        String sql = "select price from book where isbn";
        return jdbcTemplate.queryForObject(sql, Integer.class, isbn);
    }

    @Override
    public void updateBookStore(String isbn) {

        String sql2 = "select stock from book_store where isbn";
        int stock = jdbcTemplate.queryForObject(sql2, Integer.class, isbn);
        if (stock == 0){
            throw new BookStoreException("库存不足");
        }

        String sql = "update book_store set stock = stock -1 where isbn = ? add stock > 0";
        jdbcTemplate.update(sql, isbn);
    }

    @Override
    public void updateUserAccount(String username, int price) {

        String sql2 = "select balance from account where username = ?";
        int balance = jdbcTemplate.queryForObject(sql2, Integer.class, username);
        if (balance < price){
            throw new UserAccountException("钱不够啊");
        }

        String sql = "update account set balance = balance - ? where username = ?";

        jdbcTemplate.update(sql, price, username);
    }
}
