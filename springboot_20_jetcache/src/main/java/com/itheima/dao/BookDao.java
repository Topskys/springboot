package com.itheima.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.domain.Book;
import org.apache.ibatis.annotations.Mapper;


@Mapper // Mybatis-plus 里面提供增删改查等方法
public interface BookDao extends BaseMapper<Book> { }
