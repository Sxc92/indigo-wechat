package com.indigo.wechat.common.pojo;

import com.indigo.wechat.common.constant.CommonCodeEnums;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 史偕成
 * @title
 * @description
 * @create 2024-12-19 11:03
 */
@Slf4j
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {
    /**
     * 数据
     */
    private T data;

    /**
     * 消息
     */
    private String msg;

    /**
     * 编码
     */
    private int code;

    public static <T> Result<T> success(T data) {
        return new Result<>(data, CommonCodeEnums.SUCCESS.getMsg(), CommonCodeEnums.SUCCESS.getCode());
    }

    public static <T> Result<T> success(CommonCodeEnums codeEnum) {
        return new Result<>(null, codeEnum.getMsg(), codeEnum.getCode());
    }

    public static <T> Result<T> error(CommonCodeEnums codeEnum) {
        return new Result<>(null, codeEnum.getMsg(), codeEnum.getCode());
    }

    public static <T> Result<T> error() {
        return new Result<>(null, CommonCodeEnums.ERROR.getMsg(), CommonCodeEnums.ERROR.getCode());
    }
}