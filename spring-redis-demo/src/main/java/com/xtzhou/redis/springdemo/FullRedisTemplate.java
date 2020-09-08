package com.xtzhou.redis.springdemo;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.Assert;

/**
 * @author Zhouxiaotian
 * @version 1.0
 * @date 2020/9/8 17:07
 * @since 1.0
 */
public class FullRedisTemplate {
    private StringRedisTemplate redisTemplate;

    public void delBigList(String bigListKey) {
        int left = 100;
        Long len = redisTemplate.opsForList().size(bigListKey);
        Assert.notNull(len, "不能为空");
        redisTemplate.opsForList().trim(bigListKey, left, len);
    }
}
