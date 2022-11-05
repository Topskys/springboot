package com.example.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookServiceTestCase {
    @Autowired
    private BookService bookService;


    @Test
    void testInsert() {
        Book book = new Book();
        // book.setId(1); // id为自增，故不需要数据
        book.setName("springboot_insert_1");
        book.setType("jar_1");
        book.setDescription("a java jar_1");
        bookService.insert(book);
    }

    @Test
    void testDelete() {
        bookService.delete(4);
    }

    @Test
    void testUpdate() {
        Book book = new Book();
        book.setId(5);
        book.setName("springboot_update_1");
        book.setType("jar_1");
        book.setDescription("a java jar_1");
        bookService.update(book);// book.setId(3);
    }

    @Test
    void testQuery() {
        bookService.getAll();
    }


    @Test
    void testQueryBy() {
        System.out.println(bookService.getById(1));
    }

    @Test
    void testPagination() {
       IPage<Book> page=bookService.getPage(2,5);
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.getPages());
        System.out.println(page.getRecords());
    }


}
