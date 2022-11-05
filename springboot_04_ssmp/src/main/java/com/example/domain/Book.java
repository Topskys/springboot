package com.example.domain;

//Lombok，一个Java类库，提供给一组注解，简化POJO实体类开发。like：代替数据的get和set方法
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;

@Data // 代替 @Getter 和 @Setter，但没有提供构造方法@Controller
public class Book {

    private Integer id;
    private String type;
    private String name;
    private String description;
}
