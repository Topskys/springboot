package com.itheima;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest
public class SpringRedisTemplateTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate; // 这个跟终端操作结果一致，指定泛型，常用

    @Test
    void get(){
            ValueOperations<String, String> ops=stringRedisTemplate.opsForValue();
            String k1= ops.get("k1");
            System.out.println(k1);
    }
}
