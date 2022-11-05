package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling // 开启定时任务功能 SB整合task
public class Application_22_task {

    //    程序入口
    public static void main(String[] args) {
      SpringApplication.run(Application_22_task.class, args);
    }

}
