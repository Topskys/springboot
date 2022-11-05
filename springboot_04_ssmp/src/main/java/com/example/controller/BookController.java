package com.example.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.domain.Book;
import com.example.service.IBookServiceMp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController  注释防止加载，就可以运行BookControllerR
@RequestMapping("/books") // http://127.0.0.1:8002/books
public class BookController {

    @Autowired
    private IBookServiceMp bookServiceMp;

    @PostMapping
    public Boolean saveBook(@RequestBody Book book){
        return  bookServiceMp.saveBook(book);
    }

    @DeleteMapping("{id}")// http://127.0.0.1:8002/books/2
    public Boolean deleteBook(@PathVariable Integer id){// @PathVariable 参数来源
        return  bookServiceMp.deleteBook(id);
    }

    @PutMapping
    public Boolean updateBook(@RequestBody Book book){
        return  bookServiceMp.updateBook(book);
    }


    @GetMapping("{id}")
    public Book getById(@PathVariable Integer id){// id="{id}"
        return bookServiceMp.queryBook(id);
    }

    @GetMapping
    public List<Book> getAll(Book book){
        return bookServiceMp.queryBookList(book);
    }

//    @GetMapping
//    public List<Book> getAllMPList(){
//        return bookServiceMp.list();
//    }


    @GetMapping("{currentPage}/{pageSize}")
    public IPage<Book> getPage(@PathVariable int currentPage,@PathVariable int pageSize){// http://127.0.0.1:8002/books/2/10
        return  bookServiceMp.getPage(currentPage,pageSize);
    }
}
