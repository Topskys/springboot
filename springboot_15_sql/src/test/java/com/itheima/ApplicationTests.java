package com.itheima;

import com.itheima.dao.BookDao;

import com.itheima.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

// 在此测试mysql、h2等数据库库

@SpringBootTest
class ApplicationTests {

    @Autowired
    private BookDao bookDao;

    @Test
    void test() {
        bookDao.selectById(2);  // mp
    }

    // @Autowired
    // private JdbcTemplate jdbcTemplate;

    @Test
    void testJdbcTemplate(@Autowired JdbcTemplate jdbcTemplate) {
        String sql="select * from tbl_book";// where id = 1
         // List<Map<String,Object>> maps=jdbcTemplate.queryForList(sql);
         // System.out.println(maps); // [{},...]
        // 建议使用(标准格式)
        RowMapper<Book> rm = new RowMapper<Book>(){
            @Override
            public Book mapRow(ResultSet rs,int rowNum) throws SQLException {
                Book temp=new Book();
                temp.setId(rs.getInt("id"));
                temp.setName(rs.getString("name"));
                temp.setType(rs.getString("type"));
                temp.setDescription(rs.getString("description"));
                return temp;
            }
        };
        List<Book> list=jdbcTemplate.query(sql,rm);
        System.out.println(list); // [Book(),...]
    }


    @Test
    void testJdbcSave(@Autowired JdbcTemplate jdbcTemplate) {
        // String sql="insert into tbl_book values(null,'s1','s2','s3')"; // mysql
        String sql="insert into tbl_book values(3,'s1','s2','s3')";// h2
        jdbcTemplate.update(sql);
    }

}
