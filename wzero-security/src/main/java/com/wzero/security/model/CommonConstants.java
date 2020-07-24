package com.wzero.security.model;

public interface CommonConstants {
    /** 默认常量定义
     * UNAUTHENTICATION
     */
    String DEFAULT_ = "";
    String DEFAULT_LOGIN_PAGE = "/sign_in.html";
    String DEFAULT_LOGIN_URL_FORM = "/authentication/form";
    String DEFAULT_LOGIN_URL_MOBILE = "/authentication/mobile";
    String DEFAULT_LOGOUT_URL = "/logout";

    String DEFAULT_URL = "/authentication/require";



    String DEFAULT_VALIDATE_CODE_URL_PREFIX = "/code";
    String DEFAULT_SIGN_IN_PROCESSING_URL_FORM = "/authentication/form";
    String DEFAULT_SIGN_IN_PROCESSING_URL_MOBILE = "/authentication/mobile";
    String DEFAULT_SIGN_IN_PROCESSING_URL_OPENID = "/authentication/openid";

    String DEFAULT_PARAMETER_NAME_CODE_IMAGE = "imageCode";
    String DEFAULT_PARAMETER_NAME_CODE_SMS = "smsCode";
    String DEFAULT_PARAMETER_NAME_MOBILE = "mobile";
    String DEFAULT_PARAMETER_NAME_OPENID = "openId";
    String DEFAULT_PARAMETER_NAME_PROVIDERID = "providerId";
    String DEFAULT_SESSION_INVALID_URL = "/yaspeed-session-invalid.html";
}
