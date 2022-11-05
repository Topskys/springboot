package com.itheima;

import com.itheima.domain.Book;
import com.itheima.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional  //  添加@Transactional和@Rollback(false)再运行一次，不会产生测试垃圾sql数据 @Rollback()默认false
@Rollback(false) // 回滚
public class DaoTest {

    @Autowired
    private BookService bookService;

    @Test
    void testSave(){
        Book book = new Book();

        book.setName("springboot2");
        book.setType("springboot2");
        book.setDescription("Hello world2");

        bookService.save(book);
    }
}
