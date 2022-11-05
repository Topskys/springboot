package com.itheima.service.impl;



import com.alicp.jetcache.anno.*;
import com.itheima.dao.BookDao;
import com.itheima.domain.Book;
import com.itheima.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // 自定义的方法// 追加功能 一般、原始写法
public class BookServiceImpl implements BookService {

    @Autowired // 自动装配
    private BookDao bookDao;

    @Override
    @Cached(name="book_",key = "#id",expire = 3600,cacheType = CacheType.REMOTE) // jetCache 方法缓存--新增
    @CacheRefresh(refresh = 5)
    public Book getById(Integer id) {
        return bookDao.selectById(id);
    }

    @Override
    public Boolean save(Book book) {
        return bookDao.insert(book) >0;
    }

    @Override
    @CacheInvalidate(name = "book_",key = "#id")  // jetCache 方法缓存--删除
    public Boolean delete(Integer id) {
        return bookDao.deleteById(id)>0;
    }

    @Override
    @CacheUpdate(name = "book_",key = "#book.id",value = "#book")  // jetCache 方法缓存--更新
    public Boolean update(Book book) { return bookDao.updateById(book)>0; }

    @Override
    public List<Book> getAll() {
        return bookDao.selectList(null);
    }

}
