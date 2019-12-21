package com.xtzhou.redis.springdemo.jedis;


import com.xtzhou.redis.springdemo.Jedis.JedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JedisDemoTest {
    @Autowired
    JedisUtil jedisUtil;
    @Test
    public void test_JedisDemo()
    {
        jedisUtil.testJedisFunction();
    }

    @Test
    public void test_SingleJedis()
    {
        Jedis jedis=new Jedis("192.168.99.100:6379");
        jedis.set("foo", "bar");
        String value = jedis.get("foo");
    }
}
