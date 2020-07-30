package com.wzero.security.properties;

import com.wzero.security.model.CommonConstants;

/**
 * @ClassName SessionProperties
 * @Description 自定义 Session会话 属性文件
 * @Author WJJ
 * @Date 2020/7/30 15:20
 * @Version 1.0
 */
public class SessionProperties {
    /** 会话 最大值 */
    private int maximumSessions = 1;
    /** 限制登录 */
    private boolean preventsLogin;
    /** 会话 失效路径 */
    private String sessionInvalidUrl = CommonConstants.DEFAULT_SESSION_INVALID_URL;

    public SessionProperties() {}

    public int getMaximumSessions() {
        return maximumSessions;
    }
    public void setMaximumSessions(int maximumSessions) {
        this.maximumSessions = maximumSessions;
    }
    public boolean isPreventsLogin() {
        return preventsLogin;
    }
    public void setPreventsLogin(boolean preventsLogin) {
        this.preventsLogin = preventsLogin;
    }
    public String getSessionInvalidUrl() {
        return sessionInvalidUrl;
    }
    public void setSessionInvalidUrl(String sessionInvalidUrl) {
        this.sessionInvalidUrl = sessionInvalidUrl;
    }
}
