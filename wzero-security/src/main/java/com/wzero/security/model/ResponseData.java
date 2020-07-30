package com.wzero.security.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ResponseData<T> {
    /** 状态 */
    private Boolean success;
    /** 状态码 */
    private Integer code;
    /** 消息 */
    private String message;
    /** 数据 */
    private T data;

    public static ResponseData ok() {
        ResponseData r = new ResponseData();
        r.setSuccess(ResponseCode.SUCCESS.getSuccess());
        r.setCode(ResponseCode.SUCCESS.getCode());
        r.setMessage(ResponseCode.SUCCESS.getMessage());
        return r;
    }
    public static ResponseData error() {
        ResponseData r = new ResponseData();
        r.setSuccess(ResponseCode.FAILURE.getSuccess());
        r.setCode(ResponseCode.FAILURE.getCode());
        r.setMessage(ResponseCode.FAILURE.getMessage());
        return r;
    }
    public static ResponseData setResult(ResponseCode resultCodeEnum) {
        ResponseData r = new ResponseData();
        r.setSuccess(resultCodeEnum.getSuccess());
        r.setCode(resultCodeEnum.getCode());
        r.setMessage(resultCodeEnum.getMessage());
        return r;
    }

    public ResponseData isSuccess(Boolean success) {
        this.success = success;
        return this;
    }
    public ResponseData code(Integer code) {
        this.code = code;
        return this;
    }
    public ResponseData message(String message) {
        this.message = message;
        return this;
    }
    public ResponseData data(T data) {
        this.data = data;
        return this;
    }
}
