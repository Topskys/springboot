package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.dao.BookMapp;
import com.example.domain.Book;
import com.example.service.IBookServiceMp;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service
//public class BookServiceImplMp extends ServiceImpl<BookMapp, Book> implements IBookServiceMp { }


@Service // 自定义的方法// 追加功能 一般、原始写法
public class BookServiceImplMp extends ServiceImpl<BookMapp, Book> implements IBookServiceMp {

    @Autowired // 自动装配
    private BookMapp bookMap;


    @Override
    public boolean saveBook(Book book) {
        return bookMap.insert(book) >0;
    }

    @Override
    public boolean deleteBook(Integer id) {
        return bookMap.deleteById(id)>0;
    }

    @Override
    public boolean updateBook(Book book) {
        return bookMap.updateById(book)>0;
    }


    @Override
    public Book queryBook(Integer id) {
        return bookMap.selectById(id);
    }

    @Override
    public List<Book> queryBookList(Book book) {
        return bookMap.selectList(null);
    }

    @Override
    public IPage<Book> getPage(int currentPage, int pageSize) {
        IPage page=new Page(currentPage,pageSize);
        return bookMap.selectPage(page,null);
    }


    /**
     * 分页
     * @param currentPage
     * @param pageSize
     * @param book
     * @return
     * 输入“ /** ”+回车
     */
    @Override
    public IPage<Book> getPage(int currentPage, int pageSize,Book book) {
        LambdaQueryWrapper<Book> lqw=new LambdaQueryWrapper<Book>();
        lqw.like(Strings.isNotEmpty(book.getType()),Book::getType,book.getType());
        lqw.like(Strings.isNotEmpty(book.getName()),Book::getName,book.getName());
        lqw.like(Strings.isNotEmpty(book.getDescription()),Book::getDescription,book.getDescription());
        IPage page=new Page(currentPage,pageSize);
        return bookMap.selectPage(page,lqw);
    }
}
