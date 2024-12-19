package com.indigo.wechat.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.lang.annotation.Annotation;

/**
 * @author 史偕成
 * @title
 * @description
 * @create 2024-12-19 10:59
 */
@Slf4j
@Component
public class LimitFilter implements GlobalFilter, Ordered {


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // 默认放行后续过滤器
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 1;
    }
}
