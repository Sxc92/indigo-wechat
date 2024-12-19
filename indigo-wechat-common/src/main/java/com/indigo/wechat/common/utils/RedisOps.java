package com.indigo.wechat.common.utils;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @author 史偕成
 * @title
 * @description
 * @create 2024-12-19 11:16
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class RedisOps {
    private final StringRedisTemplate stringRedisTemplate;

    public Boolean set(String key, String value) {
        return stringRedisTemplate.opsForValue().setIfAbsent(key, value);
    }

    public Object get(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }
}
