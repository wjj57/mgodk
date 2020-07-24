package com.wzero.security.model;

public enum EResponse{
    /** 响应消息代码 */
    SUCCESS("000000","success","请求成功"),
    FAILURE("999999","failure","请求失败"),
    /** 认证消息代码 */
    SYS_ERROR("01000","sys_error","系统异常"),
    SERVER_ERROR("02000","server_init_error","服务器状态异常"),
    RESOURCE_ACCESS_ERROR("03000","resource_access_error","资源访问异常"),
    PARAM_CHECK_ERROR("04000","param_check_error","参数校验异常"),
    FILE_UPLOAD_ERROR("05000","file_upload_error","文件上传异常"),
    VERIFY_CODE_ERROR("06000","verify_code_send_error","验证码发送异常"),
    BIZ_CHECK_ERROR("07000","biz_check_error","业务校验异常"),
    OAUTH2_ERROR("08000","oauth2_error","oauth2鉴权异常"),
    TOKEN_INVALID("09000","token_invalid","无效的token"),
    ;

    /** 编码 */
    private String code;
    /** 标识符 */
    private String mark;
    /** 消息 */
    private String message;

    EResponse(String code, String mark, String message) {
        this.code = code;
        this.mark = mark;
        this.message = message;
    }

    public String getCode() {
        return code;
    }
    public String getMessage() {
        return message;
    }
    public String getMark() {
        return mark;
    }
}
