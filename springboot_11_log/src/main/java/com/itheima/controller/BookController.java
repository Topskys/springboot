package com.itheima.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
//Rest模式
@RestController
@RequestMapping("/books")// 访问前缀-web访问路径 localhost:端口号/books
public class BookController {

    // 统一封装一个类中，通过在pom.xml配置lombok和@Slf4j引入log对象
    // private static final Logger log= LoggerFactory.getLogger(BookController.class);

    @GetMapping
    public String getById(){
        System.out.print("springboot is running...");
        log.debug("debug...");
        log.warn("warn...");
        log.error("error...");
        log.info("info...");
        return  "springboot is running...";
    }
}
