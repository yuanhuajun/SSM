package com.controller;

import com.service.BookService;
import com.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

/**
 * @author yhj
 * @version 1.0
 * @date 2023/1/17 22:21
 * @Description
 */

@Controller
public class BookController {

    @Autowired
    private BookService bookService;
    @Autowired
    private CheckoutService checkoutService;
    public void byBook(Integer userId , Integer bookId){
        bookService.byBook(userId,bookId);
    }

    public void  checkOut(Integer userId,Integer[] bookIds){
        checkoutService.checkout(userId,bookIds);
    }

}
