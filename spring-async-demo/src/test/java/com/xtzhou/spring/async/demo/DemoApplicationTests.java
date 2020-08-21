package com.xtzhou.spring.async.demo;

import com.xtzhou.spring.async.demo.task.Task;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    Task task;

    @Test
    @SneakyThrows
    void contextLoads() {
        for (int i = 0; i < 10000; i++) {
            task.doTaskOne();
            task.doTaskTwo();
            task.doTaskThree();
            if (i == 9999) {
                System.exit(0);
            }
        }
    }

}
