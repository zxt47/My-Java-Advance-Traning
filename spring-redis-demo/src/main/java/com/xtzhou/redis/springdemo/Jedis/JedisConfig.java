package com.xtzhou.redis.springdemo.Jedis;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Slf4j
@Configuration
public class JedisConfig {
    @Autowired
    private JedisPoolConfig jedisPoolConfig;

    /**
     * 使用SpringBoot Bean注解的方式注入Bean，此处也可以采用XML
     * 其中{@link ConfigurationProperties @ConfigurationProperties} 中的默认中value=prefix=default.
     */
    @Bean
    @ConfigurationProperties("redis")
    public JedisPoolConfig jedisPoolConfig()
    {
        return new JedisPoolConfig();
    }

    @Bean(destroyMethod = "close")
    public JedisPool jedisPool(@Value("${redis.host}")String host)
    {
        return new JedisPool(jedisPoolConfig,host,6379);
    }
}
