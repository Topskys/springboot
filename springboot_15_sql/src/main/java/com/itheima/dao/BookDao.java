package com.itheima.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.domain.Book;
import org.apache.ibatis.annotations.Mapper;

// 注释掉 MP ，演示 jdbc
@Mapper
public interface BookDao extends BaseMapper<Book> { } //mp


//public interface BookDao { }  // jdbc
