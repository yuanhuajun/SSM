package com.dao;

/**
 * @author yhj
 * @version 1.0
 * @date 2023/1/17 22:22
 * @Description
 */
public interface BookDao {

    /**
     * 根据图书的id查询图书价格
     * @param bookId
     * @return
     */
    Integer getPriceByBookId(Integer bookId)  ;

    /**
     * 更新图书的库存
     * @param bookId
     */
    void updateStock(Integer bookId);

    /**
     * 更新用户的余额
     * @param userId
     * @param price
     */
    void updateBalance(Integer userId, Integer price);
}
