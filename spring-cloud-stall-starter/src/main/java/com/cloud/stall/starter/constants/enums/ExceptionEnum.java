package com.cloud.stall.starter.constants.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 异常枚举
 *
 * @author baoyw
 */
@AllArgsConstructor
public enum ExceptionEnum {

    SYS_EXCEPTION(10000, "系统错误");

    @Getter
    private Integer code;

    @Getter
    private String message;

}
