package com.xtzhou.netty.action;

import com.xtzhou.netty.action.server.BootDemoNettyServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@Slf4j
@SpringBootApplication(scanBasePackages = "com.xtzhou.netty.action")
public class NettyWithSpringBoot {
    @Autowired
    BootDemoNettyServer demoNettyServer;

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(NettyWithSpringBoot.class);
        //不要Tomcat了，因为使用Netty做为服务端了
        springApplication.setWebApplicationType(WebApplicationType.NONE);
        springApplication.run(args);
    }

    @Bean
    BootDemoNettyServer demoNettyServer() {
        BootDemoNettyServer demoNettyServer = new BootDemoNettyServer();
        try {
            demoNettyServer.bind(6379);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return demoNettyServer;
        }
    }
}
