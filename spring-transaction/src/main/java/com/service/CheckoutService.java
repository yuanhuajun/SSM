package com.service;

/**
 * @author yhj
 * @version 1.0
 * @date 2023/1/17 23:33
 * @Description
 */
public interface CheckoutService {
    void checkout(Integer userId, Integer[] bookIds);
}
