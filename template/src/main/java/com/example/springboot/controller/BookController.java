package com.example.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Rest模式
@RestController
@RequestMapping("/books")// 访问前缀-web访问路径 localhost:端口号/books
public class BookController {

    @GetMapping
    public String getById(){
        System.out.print("springboot is running...");
        return  "springboot is running...";
    }
}
