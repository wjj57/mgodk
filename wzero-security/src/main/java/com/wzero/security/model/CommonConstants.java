package com.wzero.security.model;

public interface CommonConstants {
    /** 默认常量定义
     * UNAUTHENTICATION - 未经授权；PROCESSING - 处理方式；PARAMETER - 参数；
     */
    String DEFAULT_ = "";
    String DEFAULT_LOGIN_PAGE = "/sign_in.html";
    String DEFAULT_LOGIN_URL_FORM = "/authentication/form";
    String DEFAULT_LOGIN_URL_MOBILE = "/authentication/mobile";
    String DEFAULT_LOGOUT_URL = "/logout";
    String DEFAULT_SESSION_INVALID_URL = "/session_invalid.html";

    String DEFAULT_UNAUTHENTICATION_URL = "/authentication/require";
    String DEFAULT_VALIDATE_CODE_URL_PREFIX = "/code";

    String DEFAULT_PARAMETER_NAME_CODE_IMAGE = "imageCode";
    String DEFAULT_PARAMETER_NAME_CODE_SMS = "smsCode";
    String DEFAULT_PARAMETER_NAME_FORM = "form";
    String DEFAULT_PARAMETER_NAME_MOBILE = "mobile";

}
