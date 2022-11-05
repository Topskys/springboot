package com.example.springboot_02_mybatis_plus.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springboot_02_mybatis_plus.domain.Article;
import com.example.springboot_02_mybatis_plus.domain.Book;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ArticleDao extends BaseMapper<Article>{
}

