package com.example.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.domain.Book;

import java.util.List;
// MyBatis-plus实现的业务层接口
//public interface IBookServiceMp extends IService<Book> { }

//or 自定义，追加功能 ,不得与Mp提供的方法重名,否则mp方法不可用//一般、原始写法
public interface IBookServiceMp extends IService<Book> {

    boolean saveBook(Book book);

    boolean deleteBook(Integer id);

    boolean updateBook(Book book);


    Book queryBook(Integer id);

    List<Book> queryBookList(Book book);


    IPage<Book> getPage(int currentPage,int pageSize);


    IPage<Book> getPage(int currentPage,int pageSize,Book book);


}