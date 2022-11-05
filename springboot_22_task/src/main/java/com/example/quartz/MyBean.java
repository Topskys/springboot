package com.example.quartz;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MyBean {

    @Scheduled(cron = "0/1 * * * * ?")
    public void printSBTask() {
        System.out.println(Thread.currentThread().getName() + ":springboot task run...");
    }
}
