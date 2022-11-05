package com.itheima;

import com.itheima.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;

@SpringBootTest
class ApplicationTests {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    void testMongodb(){
        Book temp=new Book();

        temp.setId(1);
        temp.setName("springboot2");
        temp.setType("springboot2");
        temp.setDescription("Hello world2");

        mongoTemplate.save(temp);
    }

    @Test
    void testFind(){
       List<Book> all=mongoTemplate.findAll(Book.class);
       System.out.println(all);
    }


}
