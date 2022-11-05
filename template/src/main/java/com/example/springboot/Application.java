package com.example.springboot;

import com.example.springboot.controller.BookController;
import org.springframework.boot.ConfigurableBootstrapContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    //    程序入口
    public static void main(String[] args) {
      SpringApplication.run(Application.class, args);
        System.out.print("Hello,World");
    }

}
