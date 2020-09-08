package com.xtzhou.spring.async.demo.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * @author Zhouxiaotian
 * @version 1.0
 * @date 2020/9/8 9:42
 * @since 1.0
 */
@Slf4j
@Configuration
public class ContextRefreshListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.info("Spring Context Refresh");
        log.info("[{}]",event.getApplicationContext());
    }
}
