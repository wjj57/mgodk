package com.wzero.security.model;

public enum ResponseCode {
    /** 一般响应消息 */
    DEFAULT(true,0,"default","default"),
    SUCCESS(true,20000,"success","成功"),
    FAILURE(false,30000,"failure","失败"),
    UNKNOWN_REASON(false, 30001,"", "未知错误"),
    SYSTEM_ERROR(false,30002,"system_error","系统异常"),
    SERVER_ERROR(false,30003,"server_error","服务器异常"),
    RESOURCE_ACCESS_ERROR(false,30004,"resource_access_error","资源访问异常"),
    /** 其它类型响应消息 */
    PARAM_CHECK_ERROR(false,30050,"param_check_error","参数校验异常"),
    FILE_UPLOAD_ERROR(false,30051,"file_upload_error","文件上传异常"),
    SESSION_INVALIDE(false,30100,"session_invalid","session 失效"),
    SESSION_EXPIRED(false,30101,"session_expired","session 过期"),
    SESSION_MAX_EXCEEDED(false,30102,"session_max_exceeded","您已在别处登录，请您修改密码或重新登录"),
    /** 认证响应消息 */
    VALIDATE_CODE_ERROR(false,30201,"validate_code_error","验证码发送异常"),
    USERNAME_NOT_FOUND(false,30202,"username_not_found","用户名不存在"),
    PASSWORD_ERROR(false,30203,"password_error","密码错误"),
    VERIFY_CODE_ERROR(false,30204,"verify_code_error","验证码错误"),
    TOKEN_INVALIDE(false,30205,"token_invalide","无效的 token"),
    OAUTH2_ERROR(false,30206,"oauth2_error","oauth2 鉴权异常"),
    ;

    /** 状态 */
    private Boolean success;
    /** 编码 */
    private Integer code;
    /** 标识符 */
    private String tag;
    /** 消息 */
    private String message;

    ResponseCode(Boolean success, Integer code, String tag, String message) {
        this.success = success;
        this.code = code;
        this.tag = tag;
        this.message = message;
    }

    public Boolean isSuccess() {
        return this.success;
    }
    public Integer getCode() {
        return this.code;
    }
    public String getTag() {
        return this.tag;
    }
    public String getMessage() {
        return this.message;
    }
}
