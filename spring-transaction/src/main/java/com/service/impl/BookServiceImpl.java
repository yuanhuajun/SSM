package com.service.impl;

import com.dao.BookDao;
import com.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;

/**
 * @author yhj
 * @version 1.0
 * @date 2023/1/17 22:22
 * @Description
 */

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;
    @Override
    @Transactional(
            timeout = 3 , //超时强制回滚并抛出异常
            //readOnly = true
            //noRollbackFor = ArithmeticException.class  对于数学运算异常不回滚
            noRollbackForClassName = "java.lang.ArithmeticException",
            // isolation = Isolation.REPEATABLE_READ 设置隔离级别
            propagation = Propagation.REQUIRES_NEW
    )
    public void byBook(Integer userId, Integer bookId)   {
        //查询图书价格
        Integer price =bookDao.getPriceByBookId(bookId);
        // try {
        //     TimeUnit.SECONDS.sleep(5);
        // } catch (InterruptedException e) {
        //     throw new RuntimeException(e);
        // }
        //更新图书库存
        bookDao.updateStock(bookId);
        //更新用户余额
        bookDao.updateBalance(userId,price);
        int a=10/0;
    }
}
