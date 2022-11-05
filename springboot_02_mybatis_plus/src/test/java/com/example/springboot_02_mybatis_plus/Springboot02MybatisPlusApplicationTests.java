package com.example.springboot_02_mybatis_plus;

import com.example.springboot_02_mybatis_plus.dao.ArticleDao;
import com.example.springboot_02_mybatis_plus.dao.BookDao;
import com.example.springboot_02_mybatis_plus.domain.Article;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot02MybatisPlusApplicationTests {

    @Autowired
    private BookDao bookDao;

    @Autowired
    private ArticleDao articleDao;

    @Test
    void contextLoads() {

//        System.out.println(bookDao.selectById(1));
//        System.out.println(bookDao.selectList(null));// 查列表全部
        System.out.println(articleDao.selectById(1));
        System.out.println(articleDao.selectList(null));
    }// 调用BaseMapper的方法selectById()
    // 运行报错'my_db_01.book' doesn't exist，跟数据库表有关
    // 由于MP不需要自己写SQL语句，它不认识_等，需要单独配置like：*.yml # 设置MP相关配置

}
