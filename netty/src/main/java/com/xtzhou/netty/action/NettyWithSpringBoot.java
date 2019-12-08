package com.xtzhou.netty.action;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NettyWithSpringBoot {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(NettyWithSpringBoot.class);
        //不要Tomcat了，因为使用Netty做为服务端了
        springApplication.setWebApplicationType(WebApplicationType.NONE);
        springApplication.run(args);
    }

}
