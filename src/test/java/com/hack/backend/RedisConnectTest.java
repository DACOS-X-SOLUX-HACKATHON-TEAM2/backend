package com.hack.backend;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class RedisConnectTest {
    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Test
    void 레디스_테스트() {
        redisTemplate.opsForValue().set("hello","world");
        String result = redisTemplate.opsForValue().get("hello");
        assertEquals("world",result);
    }
}
