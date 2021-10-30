package com.example.demo.config;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TaskConfig {



    @Scheduled(cron = "0 0 12 * * ?")
    public void doTask(){
        System.out.println("执行任务");
    }
}
