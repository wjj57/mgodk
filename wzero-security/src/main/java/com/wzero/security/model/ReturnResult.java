package com.wzero.security.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @ClassName ReturnResult
 * @Description 响应返回数据类型
 * @Author WJJ
 * @Date 2020/08/20 11:32
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReturnResult {
    public static int SUCCESS_CODE = 0;
    public static int FAILURE_CODE = 1;

    /**状态码*/
    private int code;
    /**消息*/
    private String message;
    /**数据*/
    private Object data;

    public static ReturnResult result(int code, String message, Object data) {
        return new ReturnResult(code,message,data);
    }
    public static ReturnResult success(String message) {
        return new ReturnResult(SUCCESS_CODE,message,null);
    }
    public static ReturnResult success(Object data) {
        return new ReturnResult(SUCCESS_CODE,"",data);
    }
    public static ReturnResult success(String message, Object data) {
        return new ReturnResult(SUCCESS_CODE,message,data);
    }
    public static ReturnResult failure(String message) {
        return new ReturnResult(FAILURE_CODE,message,null);
    }
    public static ReturnResult failure(Object data) {
        return new ReturnResult(FAILURE_CODE,"",data);
    }
    public static ReturnResult failure(String message, Object data) {
        return new ReturnResult(FAILURE_CODE,message,data);
    }
}
