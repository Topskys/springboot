package com.itheima.controller;


import com.itheima.domain.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController
@RequestMapping("/books")
public class BookController {

//    @GetMapping
//    public String getById() {
//        System.out.println("getById...");
//        return "springboot2";
//    }


    @GetMapping
    public Book getById() {
        System.out.println("getById-json is running...");

        Book book = new Book();
        book.setId(1);
        book.setName("匹配响应体json");
        book.setType("springboot");
        book.setDescription("Hello world");
        return book;
    }
}
