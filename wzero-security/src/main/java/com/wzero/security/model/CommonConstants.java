package com.wzero.security.model;

public interface CommonConstants {
    /** 默认常量定义
     * UNAUTHENTICATION - 未经授权；PROCESSING - 处理方式；PARAMETER - 参数；
     * SecurityProperties 属性前缀，可以使用常量；
     * ImageCodeProperties SmsCodeProperties 有私有属性值；
     * SessionProperties BrowserProperties
     */
    /**  */
    String DEFAULT_ = "";
    String DEFAULT_LOGIN_PAGE = "/sign_in.html";
    String DEFAULT_LOGON_PAGE = "/sign_up.html";
    String DEFAULT_LOGOUT_PAGE = "/logout.html";
    String DEFAULT_LOGOUT_URL = "/logout";

    /** session 失效默认的 跳转页面 */
    String DEFAULT_SESSION_INVALID_PAGE = "/session_invalid.html";
    /** session 失效默认的 跳转地址 */
    String DEFAULT_SESSION_INVALID_URL = "/session/invalid";

    /** 默认的 当请求需要身份认证时，跳转的 url */
    String DEFAULT_UNAUTHENTICATION_URL = "/authentication/require";
    /** 默认的 用户名密码登录请求处理 url */
    String DEFAULT_LOGIN_FORM_URL = "/authentication/form";
    /** 默认的 手机验证码登录请求处理 url */
    String DEFAULT_LOGIN_MOBILE_URL = "/authentication/mobile";

    /** 默认的 处理验证码的 url前缀 */
    String DEFAULT_VALIDATE_CODE_URL_PREFIX = "/code";
    /** 默认参数名称 验证图片验证码时，http请求中携带图片验证码信息的参数 */
    String DEFAULT_PARAMETER_NAME_CODE_IMAGE = "imageCode";
    /** 默认参数名称 验证短信验证码时，http请求中携带短信验证码信息的参数 */
    String DEFAULT_PARAMETER_NAME_CODE_SMS = "smsCode";
    /** 默认参数名称 验证图片验证码时，传递表单的参数 */
    String DEFAULT_PARAMETER_NAME_FORM = "form";
    /** 默认参数名称 发送短信验证码 或 验证短信验证码时，传递手机号的参数 */
    String DEFAULT_PARAMETER_NAME_MOBILE = "mobile";
    /** 默认参数名称 代码处理器 */
    String DEFAULT_PARAMETER_NAME_SEPARATOR = "CodeProcessor";

    /** 图片格式 */
    String IMAGE_FORMAT_NAME_PNG = "png";
    String IMAGE_FORMAT_NAME_JPEG = "jpeg";

    /** HTTP 请求 */
    String HTTP_METHOD_POST = "POST";
    String HTTP_METHOD_GET = "GET";
    String HTTP_METHOD_DELECT = "DELECT";
    String HTTP_METHOD_PUT = "PUT";
    String HTTP_CONTENT_TYPE_JSON = "application/json;charset=UTF-8";
    String HTTP_CONTENT_TYPE_HTML = "text/html;charset=UTF-8";

}
