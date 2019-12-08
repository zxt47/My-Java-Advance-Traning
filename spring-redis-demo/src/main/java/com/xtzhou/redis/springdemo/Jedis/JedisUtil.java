package com.xtzhou.redis.springdemo.Jedis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Slf4j
@Component
public class JedisUtil {
    @Autowired
    private JedisPool jedisPool;

    public void testJedisFunction()
    {
        Jedis jedis=jedisPool.getResource();
        log.info(jedis.toString());
        jedis.append("Test","123");
    }
}
