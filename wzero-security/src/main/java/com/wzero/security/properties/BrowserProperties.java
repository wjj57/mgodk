package com.wzero.security.properties;

import com.wzero.security.model.CommonConstants;
import com.wzero.security.model.ResponseType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @ClassName BrowserProperties
 * @Description 自定义 浏览器 属性文件
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BrowserProperties {
    /** 登录 页面 */
    private String signInPage = CommonConstants.DEFAULT_LOGIN_PAGE;
    /** 退出 路径 */
    private String signOutUrl = CommonConstants.DEFAULT_LOGOUT_URL;
    /** 注册 页面 */
    private String signUpUrl = CommonConstants.DEFAULT_LOGON_PAGE;
    /** 登录成功 路径 */
    private String singInSuccessUrl = CommonConstants.DEFAULT_LOGIN_SUCCESS_PAGE;
    /** 记住我 时间 */
    private int rememberMeSeconds = 3600;
    /** 登录 请求响应方式 */
    private ResponseType signInResponseType = ResponseType.JSON;
    /** 会话 */
    private SessionProperties session = new SessionProperties();

}
