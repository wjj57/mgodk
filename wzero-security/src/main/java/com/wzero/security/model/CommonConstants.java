package com.wzero.security.model;

public interface CommonConstants {
    /** 默认常量定义
     * UNAUTHENTICATION - 未经授权；PROCESSING - 处理方式；PARAMETER - 参数；
     * SecurityProperties 属性前缀，可以使用常量；
     * ImageCodeProperties SmsCodeProperties 有私有属性值；
     * SessionProperties BrowserProperties
     */
    String DEFAULT_ = "";
    String DEFAULT_LOGIN_PAGE = "/sign_in.html";
    String DEFAULT_LOGON_PAGE = "/sign_up.html";
    String DEFAULT_LOGOUT_PAGE = "/logout.html";
    String DEFAULT_SESSION_INVALID_PAGE = "/session_invalid.html";

    String DEFAULT_LOGIN_FORM_URL = "/authentication/form";
    String DEFAULT_LOGIN_MOBILE_URL = "/authentication/mobile";
    String DEFAULT_LOGOUT_URL = "/logout";
    String DEFAULT_SESSION_INVALID_URL = "/session_invalid.html";

    String DEFAULT_UNAUTHENTICATION_URL = "/authentication/require";
    String DEFAULT_VALIDATE_CODE_URL_PREFIX = "/code";

    String DEFAULT_PARAMETER_NAME_CODE_IMAGE = "imageCode";
    String DEFAULT_PARAMETER_NAME_CODE_SMS = "smsCode";
    String DEFAULT_PARAMETER_NAME_FORM = "form";
    String DEFAULT_PARAMETER_NAME_MOBILE = "mobile";
    String DEFAULT_PARAMETER_NAME_SEPARATOR = "CodeProcessor";

    /** 图片格式 */
    String IMAGE_FORMAT_NAME_PNG = "png";

    /** HTTP 请求 */
    String HTTP_METHOD_POST = "POST";
    String HTTP_METHOD_GET = "GET";
    String HTTP_METHOD_DELECT = "DELECT";
    String HTTP_METHOD_PUT = "PUT";
    String HTTP_CONTENT_TYPE_JSON = "application/json;charset=UTF-8";
    String HTTP_CONTENT_TYPE_HTML = "text/html;charset=UTF-8";

}
