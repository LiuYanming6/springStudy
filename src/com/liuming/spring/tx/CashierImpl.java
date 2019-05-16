package com.liuming.spring.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: 刘艳明
 * @Date: 19-5-16 上午7:44
 *
 * 事务中调用另外一个事务,是如何工作的(传播)
 * 1. REQUIRED     加入原有的事务(默认行为), 最后一本买不了,前边的也买不了
 * 2. REQUIRES_NEW 新开一个事务, 能买几本买几本
 */
@Service("cashier")
public class CashierImpl implements Cashier {

    @Autowired
    private BookShopService bookShopService;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void checkout(String username, List<String> isbns) {
        for (String isbn: isbns){
            bookShopService.purchase(username, isbn);
        }
    }
}
