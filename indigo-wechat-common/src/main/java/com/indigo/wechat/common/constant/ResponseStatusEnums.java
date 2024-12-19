package com.indigo.wechat.common.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author 史偕成
 * @title
 * @description
 * @create 2024-12-19 11:06
 */
@Getter
@AllArgsConstructor
public enum ResponseStatusEnums implements BasicEnums {
    SUCCESS(200, "SUCCESS"),

    ERROR(500, "ERROR"),
    ;

    private final int code;

    private final String msg;

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }
}
