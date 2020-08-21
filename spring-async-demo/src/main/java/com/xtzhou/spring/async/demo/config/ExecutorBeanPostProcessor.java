package com.xtzhou.spring.async.demo.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@Slf4j
public class ExecutorBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof ThreadPoolTaskExecutor)
        {
            log.info("追加shutdown时间");
            ThreadPoolTaskExecutor threadPoolTaskExecutor=(ThreadPoolTaskExecutor)bean;
            threadPoolTaskExecutor.setWaitForTasksToCompleteOnShutdown(true);
            threadPoolTaskExecutor.setAwaitTerminationSeconds(60);
            return threadPoolTaskExecutor;
        }
        return bean;
    }
}
