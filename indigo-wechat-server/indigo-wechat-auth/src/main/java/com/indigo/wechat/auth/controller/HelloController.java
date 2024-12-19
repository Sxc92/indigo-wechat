package com.indigo.wechat.auth.controller;

import com.indigo.wechat.common.utils.RedisOps;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 史偕成
 * @title
 * @description
 * @create 2024-12-19 10:45
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/h")
public class HelloController {

    private final RedisOps redisOps;

    @GetMapping("/he")
    public String hello() {
        redisOps.set("key1", "helloWorld!");
        return "hello";
    }
}
