package com.example.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

// Ctrl + Alt + L 格式化code


@SpringBootTest
public class BookMappTestCase {

    // 导入类
    @Autowired
    private BookMapp bookMapp;

//    @Test
//    void testGetById() {
//        System.out.println(bookMapp.getById(1)); // 单个查询
//    }


    // Mybatis-plus ----增删改查API

    @Test
    void testInsert() {
        Book book = new Book();
        // book.setId(1); // id为自增，故不需要数据
        book.setName("springboot_insert");
        book.setType("jar");
        book.setDescription("a java jar");
        bookMapp.insert(book);
    }

    @Test
    void testDelete() {
        bookMapp.deleteById(3);
    }

    @Test
    void testUpdate() {
        Book book = new Book();
        book.setId(3);
        book.setName("springboot_update");
        book.setType("jar");
        book.setDescription("a java jar");
        bookMapp.updateById(book);// book.setId(3);
    }

    @Test
    void testQuery() {

        //   System.out.println(bookMapp.selectList(null));
        bookMapp.selectList(null); // 已经开启Mp日志*.yml，代替System.out.println(what);
    }


    @Test
    void testQueryBy() {
        // 方法1
//        QueryWrapper<Book> qw=new QueryWrapper<>();
//        qw.like("name","Topsky");// %key% // SELECT id,type,name,description FROM tbl_book WHERE (name LIKE ?)
//        bookMapp.selectList(qw);

        // 写法2 防止列名拼写错误
        String name="Topsky";
        LambdaQueryWrapper<Book> lqw=new LambdaQueryWrapper<Book>();
        // name!=null == if (name!=null) lqw.like(Book::getName,name);
        // or Strings.isNotEmpty(name) replaces name!=null
        lqw.like(name!=null,Book::getName,name);
        bookMapp.selectList(lqw);
    }

    @Test
    void testPagination() { // 分页
        // select * from table_name ，分页方法有需要自己配置，
        // SELECT id,type,name,description FROM tbl_book LIMIT ?，
        //    第一页只需一个？
        // SELECT id,type,name,description FROM tbl_book LIMIT ?,? // 第二页以后
        IPage page=new Page(2,1);
        bookMapp.selectPage(page,null);
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.getPages());
        System.out.println(page.getRecords());
    }


}



