package com.itheima.controller;


import com.itheima.domain.Book;
import com.itheima.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books") // http://127.0.0.1:8002/books
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("{id}")
    public Book getById(@PathVariable Integer id){
        return  bookService.getById(id);
    }

    @PostMapping
    public Boolean save(@RequestBody Book book){
        return  bookService.save(book);
    }

    @DeleteMapping("{id}")// http://127.0.0.1:8002/books/2
    public Boolean delete(@PathVariable Integer id){// @PathVariable 参数来源
        return  bookService.delete(id);
    }

    @PutMapping
    public Boolean update(@RequestBody Book book){
        return  bookService.update(book);
    }



}
