package com.liuming.spring.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: 刘艳明
 * @Date: 19-5-16 上午7:44
 *
 * 事务中调用另外一个事务,是如何工作的(传播)
 * 1. REQUIRED     加入原有的事务(默认行为), 最后一本买不了,前边的也买不了
 * 2. REQUIRES_NEW 原事务挂起新开一个事务, 能买几本买几本
 *
 * 使用isolation指定事务的隔离级别,解决并发事务所导致的问题,脏读,不可重复读,幻读
 * 最常用的是READ_COMMITTED
 *
 *  noRollbackFor,默认情况下spring的声明式事务对所有的运行时异常进行回滚
 *
 *  使用readOnly指定事务是否为只读(只读取不更新数据),这样可以帮助数据库引擎优化事务
 *
 *  使用timeout指定强制回滚之前事务可以占用的时间
 */
@Service("cashier")
public class CashierImpl implements Cashier {

    @Autowired
    private BookShopService bookShopService;

    @Transactional(propagation = Propagation.REQUIRES_NEW,
    isolation = Isolation.READ_COMMITTED,
    noRollbackFor = {UserAccountException.class},
    readOnly = false,
    timeout = 3)
    @Override
    public void checkout(String username, List<String> isbns) {
        for (String isbn: isbns){
            bookShopService.purchase(username, isbn);
        }
    }
}
