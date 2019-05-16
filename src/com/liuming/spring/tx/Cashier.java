package com.liuming.spring.tx;

import java.util.List;

/**
 * @Author: 刘艳明
 * @Date: 19-5-16 上午7:43
 */
public interface Cashier {
    void checkout(String username, List<String> isbns);
}
