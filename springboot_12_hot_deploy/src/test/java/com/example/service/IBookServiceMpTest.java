package com.example.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.example.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class IBookServiceMpTest {
    @Autowired
    private IBookServiceMp iBookServiceMp;


    @Test
    void testInsert() {
        Book book = new Book();
        // book.setId(1); // id为自增，故不需要数据
        book.setName("springboot_insert_2");
        book.setType("jar_2");
        book.setDescription("a java jar_2");
        iBookServiceMp.save(book);
    }

    @Test
    void testDelete() {
        iBookServiceMp.removeById(4);
    }

    @Test
    void testUpdate() {
        Book book=new Book();
        book.setId(5);
        book.setName("springboot_update_2");
        book.setType("jar_1");
        book.setDescription("a java jar_2");
        iBookServiceMp.updateById(book);// book.setId(3);
    }

    @Test
    void testQuery() {
        iBookServiceMp.list();
    }


    @Test
    void testQueryBy() {
        System.out.println(iBookServiceMp.getById(8));
    }

    @Test
    void testPagination() {
       IPage<Book> page=new Page<>(2,5);
        iBookServiceMp.page(page);// return page
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.getPages());
        System.out.println(page.getRecords());
    }


}
