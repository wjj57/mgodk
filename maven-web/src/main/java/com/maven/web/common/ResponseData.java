package com.maven.web.common;

public class ResponseData<T> {
    /** 状态 */
    private Boolean success;
    /** 状态码 */
    private Integer code;
    /** 标识符 */
    private String tag;
    /** 消息 */
    private String message;
    /** 数据 */
    private T data;

    public static ResponseData ok() {
        ResponseData r = new ResponseData();
        r.setSuccess(ResponseCode.SUCCESS.isSuccess());
        r.setCode(ResponseCode.SUCCESS.getCode());
        r.setTag(ResponseCode.SUCCESS.getTag());
        r.setMessage(ResponseCode.SUCCESS.getMessage());
        return r;
    }
    public static ResponseData error() {
        ResponseData r = new ResponseData();
        r.setSuccess(ResponseCode.FAILURE.isSuccess());
        r.setCode(ResponseCode.FAILURE.getCode());
        r.setTag(ResponseCode.FAILURE.getTag());
        r.setMessage(ResponseCode.FAILURE.getMessage());
        return r;
    }
    public static ResponseData setResult(ResponseCode responseCode) {
        ResponseData r = new ResponseData();
        r.setSuccess(responseCode.isSuccess());
        r.setCode(responseCode.getCode());
        r.setTag(responseCode.getTag());
        r.setMessage(responseCode.getMessage());
        return r;
    }

    public ResponseData isSuccess(Boolean success) {
        this.setSuccess(success);
        return this;
    }
    public ResponseData code(Integer code) {
        this.setCode(code);
        return this;
    }
    public ResponseData tag(String tag) {
        this.setTag(tag);
        return this;
    }
    public ResponseData message(String message) {
        this.setMessage(message);
        return this;
    }
    public ResponseData data(T data) {
        this.setData(data);
        return this;
    }


    public Boolean getSuccess() {
        return success;
    }
    public void setSuccess(Boolean success) {
        this.success = success;
    }
    public Integer getCode() {
        return code;
    }
    public void setCode(Integer code) {
        this.code = code;
    }
    public String getTag() {
        return tag;
    }
    public void setTag(String tag) {
        this.tag = tag;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }
}
