package com.example.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.service.BookService;
import com.example.dao.BookMapp;
import com.example.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapp bookMapp;


    @Override
    public Boolean insert(Book book) {
        return bookMapp.insert(book) > 0;// 影响行数大于0表示成功
    }

    @Override
    public Boolean update(Book book) {
        return bookMapp.updateById(book)>0;
    }

    @Override
    public Boolean delete(Integer id) {
        return bookMapp.deleteById(id)>0;
    }

    @Override
    public Book getById(Integer id) {
        return bookMapp.selectById(id);
    }

    @Override
    public List<Book> getAll() {
        return bookMapp.selectList(null);
    }

    @Override
    public IPage<Book> getPage(int currentPage, int pageSize) {
        IPage page=new Page(currentPage,pageSize);
        bookMapp.selectPage(page,null);//        return bookMapp.selectPage(page,null);// 查询条件为null
        return page;
    }


}
