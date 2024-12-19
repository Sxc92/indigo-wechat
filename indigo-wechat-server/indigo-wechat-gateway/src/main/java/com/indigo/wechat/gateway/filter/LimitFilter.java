package com.indigo.wechat.gateway.filter;

import cn.hutool.core.net.Ipv4Util;
import cn.hutool.core.net.NetUtil;
import cn.hutool.json.JSONUtil;
import com.indigo.wechat.common.constant.ResponseStatusEnums;
import com.indigo.wechat.common.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.MimeType;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;

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
        // 获取请求路径
        if (1 == 1) {
           return renderErrorMsg(exchange, ResponseStatusEnums.ERROR);
        }
        // 默认放行后续过滤器
        return chain.filter(exchange);
    }

    protected Mono<Void> doLimit(ServerWebExchange exchange,
                                 GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
//        NetUtil.re
    }


    protected Mono<Void> renderErrorMsg(ServerWebExchange exchange, ResponseStatusEnums responseStatusEnums) {
        ServerHttpResponse response = exchange.getResponse();

        Result<Object> result = Result.error(responseStatusEnums);

        if (!response.getHeaders().containsKey("Content-Type")) {
            response.getHeaders().add("Content-Type", MimeTypeUtils.APPLICATION_JSON_VALUE);
        }

        response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);

        DataBuffer wrap = response.bufferFactory().wrap(JSONUtil.toJsonStr(result).getBytes(StandardCharsets.UTF_8));
        return response.writeWith(Mono.just(wrap));

    }


    @Override
    public int getOrder() {
        return 1;
    }
}
