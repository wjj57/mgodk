package com.maven.web.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName ReturnResult
 * @Description 响应返回数据类型
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReturnResult {
    public static int SUCCESS_CODE = 0;
    public static int FAILURE_CODE = 1;

    /** 状态 */
    private Boolean success;
    /** 状态码 */
    private Integer code;
    /** 标识符 */
    private String tag;
    /** 消息 */
    private String message;
    /** 数据 */
    private Object data;

    public static ReturnResult setResult(Boolean isSuccess, Integer code, String tag, String message, Object data) {
        return new ReturnResult(isSuccess,code,tag,message,data);
    }
    public static ReturnResult setResult(Boolean isSuccess, Integer code, String message, Object data) {
        return new ReturnResult(isSuccess,code,null,message,data);
    }

    public static ReturnResult success(Object data) {
        return new ReturnResult(ResponseCode.SUCCESS.isSuccess(),ResponseCode.SUCCESS.getCode(),ResponseCode.SUCCESS.getTag(),
                null,data);
    }
    public static ReturnResult success(String message, Object data) {
        return new ReturnResult(ResponseCode.SUCCESS.isSuccess(),ResponseCode.SUCCESS.getCode(),ResponseCode.SUCCESS.getTag(),
                message,data);
    }

    public static ReturnResult failure(Object data) {
        return new ReturnResult(ResponseCode.FAILURE.isSuccess(),ResponseCode.FAILURE.getCode(),ResponseCode.FAILURE.getTag(),
                null,data);
    }
    public static ReturnResult failure(String message, Object data) {
        return new ReturnResult(ResponseCode.FAILURE.isSuccess(),ResponseCode.FAILURE.getCode(),ResponseCode.FAILURE.getTag(),
                message,data);
    }
}
