package com.xtzhou.spring.async.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
public class ThreadPoolDemo {
    @Bean
    public Executor taskExecutor()
    {
        ThreadPoolTaskExecutor threadPoolTaskExecutor=new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setThreadNamePrefix("TaskExecutor-1-Thread-");
        return threadPoolTaskExecutor;
    }

    @Bean
    public Executor taskExecutor2()
    {
        ThreadPoolTaskExecutor threadPoolTaskExecutor=new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setThreadNamePrefix("TaskExecutor-2-Thread-");
        return threadPoolTaskExecutor;
    }
}
