package com.cloud.stall.starter.exception;


import com.cloud.stall.starter.constants.enums.ExceptionEnum;

/**
 * 业务全局异常类
 *
 * @author baoyw
 */
public class BusinessException extends RuntimeException {
    private Integer code;
    private String msg;

    /**
     * 自定义异常
     *
     * @param code
     * @param msg
     */
    public BusinessException(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 普通确认异常
     *
     * @param msg
     */
    public BusinessException(String msg) {
        this.code = ExceptionEnum.SYS_EXCEPTION.getCode();
        this.msg = msg;
    }

    public BusinessException(ExceptionEnum exceptionEnum) {
        this.code = exceptionEnum.getCode();
        this.msg = exceptionEnum.getMessage();
    }


    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
