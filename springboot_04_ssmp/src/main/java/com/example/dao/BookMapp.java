package com.example.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.domain.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

//@Mapper
//public interface BookMapp {
//
//    @Select("select * from tbl_book where id= #{id}")
//    Book getById(Integer id);
//}

// Mybatis-plus 里面提供增删改查等方法
@Mapper
public interface BookMapp extends BaseMapper<Book> { }
