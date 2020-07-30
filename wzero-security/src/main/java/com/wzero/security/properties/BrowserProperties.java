package com.wzero.security.properties;

import com.wzero.security.model.CommonConstants;
import com.wzero.security.model.ResponseType;

/**
 * @ClassName BrowserProperties
 * @Description 自定义 浏览器 属性文件
 * @Author WJJ
 * @Date 2020/7/30 15:13
 * @Version 1.0
 */
public class BrowserProperties {
    /** 登录 页面 */
    private String signInPage = CommonConstants.DEFAULT_LOGIN_PAGE;
    /** 退出 路径 */
    private String signOutUrl = CommonConstants.DEFAULT_LOGOUT_URL;
    /** 注册 页面 */
    private String signUpUrl = CommonConstants.DEFAULT_LOGON_PAGE;
    /** 登录成功 路径 */
    private String singInSuccessUrl;
    /** 记住我 时间 */
    private int rememberMeSeconds = 3600;
    /** 登录 请求响应方式 */
    private ResponseType signInResponseType = ResponseType.JSON;
    /** 会话 */
    private SessionProperties session = new SessionProperties();

    public BrowserProperties() {}

    public String getSignInPage() {
        return signInPage;
    }
    public void setSignInPage(String signInPage) {
        this.signInPage = signInPage;
    }
    public String getSignOutUrl() {
        return signOutUrl;
    }
    public void setSignOutUrl(String signOutUrl) {
        this.signOutUrl = signOutUrl;
    }
    public String getSignUpUrl() {
        return signUpUrl;
    }
    public void setSignUpUrl(String signUpUrl) {
        this.signUpUrl = signUpUrl;
    }
    public String getSingInSuccessUrl() {
        return singInSuccessUrl;
    }
    public void setSingInSuccessUrl(String singInSuccessUrl) {
        this.singInSuccessUrl = singInSuccessUrl;
    }
    public int getRememberMeSeconds() {
        return rememberMeSeconds;
    }
    public void setRememberMeSeconds(int rememberMeSeconds) {
        this.rememberMeSeconds = rememberMeSeconds;
    }
    public ResponseType getSignInResponseType() {
        return signInResponseType;
    }
    public void setSignInResponseType(ResponseType signInResponseType) {
        this.signInResponseType = signInResponseType;
    }
    public SessionProperties getSession() {
        return session;
    }
    public void setSession(SessionProperties session) {
        this.session = session;
    }
}
