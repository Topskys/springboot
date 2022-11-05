package com.example.springboot_02_mybatis_plus.dao;


import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springboot_02_mybatis_plus.domain.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface BookDao extends BaseMapper<Book> {
    // 使用MyBatis-plus 可以直接继承 BaseMapper<实体对象> // 里面包含许多方法，增删改查
//    @Select("select * from ev_article_cate where id = #{id}") // tbl_book
//    public Book getById(Integer id);
}
