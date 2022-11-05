package com.example.springboot_01_mybatis.dao;

import com.example.springboot_01_mybatis.domain.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface BookDao {

    @Select("select * from ev_article_cate where id = #{id}") // tbl_book
    public Book getById(Integer id);
}
