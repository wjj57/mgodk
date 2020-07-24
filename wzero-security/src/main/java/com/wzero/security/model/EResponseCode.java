package com.wzero.security.model;

public enum EResponseCode {
    /** 一般响应消息 */
    SUCCESS(true,20000,"成功"),
    FAILURE(false,20001,"失败"),
    UNKNOWN_REASON(false, 20002, "未知错误"),
    /** 其它类型响应消息 */
    SESSION_INVALIDE(false,20010,"session失效"),
    VERIFICATION_ERROR(false,20011,"访问服务器需要验证，需要引导到登录页"),
    USERNAME_ERROR(false,20012,"用户名不存在"),
    PASSOWRD_ERROR(false,20013,"密码错误"),
    VALIDATE_CODE_ERROR(false,20014,"验证码错误"),
    LOGIN_FAILURE(false,20015,"登录失败"),
    MAX_SESSION_EXCEEDED(false,20016,"您已在别处登录，请您修改密码或重新登录"),
    ;

    /** 状态 */
    private Boolean success;
    /** 编码 */
    private Integer code;
    /** 消息 */
    private String message;

    EResponseCode(Boolean success, Integer code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }
    public Integer getCode() {
        return code;
    }
    public String getMessage() {
        return message;
    }
}
