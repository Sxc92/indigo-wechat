package com.indigo.wechat.gateway.config;

import com.indigo.wechat.common.constant.BasicProperty;
import lombok.Data;
import org.apache.commons.lang3.time.DurationUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import static com.indigo.wechat.gateway.config.GatewayProperty.*;

/**
 * @author 史偕成
 * @title
 * @description
 * @create 2024-12-19 15:46
 */
@Data
@Configuration
@ConfigurationProperties(prefix = GATEWAY_PREFIX)
public class GatewayProperty {
    public static final String GATEWAY_PREFIX = BasicProperty.BASIC_PREFIX + ".gateway";
    /**
     * IP 访问时间范围
     */
    private int ipLimitTime;
    /**
     * IP 访问次数限制
     */
    private int ipLimitCount;

    private ChronoUnit ipLimitTimeUnit;

    private int silentTime;
}
