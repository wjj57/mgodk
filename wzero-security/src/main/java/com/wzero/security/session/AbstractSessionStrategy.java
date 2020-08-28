package com.wzero.security.session;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wzero.security.model.CommonConstants;
import com.wzero.security.model.ResponseCode;
import com.wzero.security.model.ResponseData;
import com.wzero.security.properties.SecurityProperties;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.util.UrlUtils;
import org.springframework.util.Assert;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName AbstractSessionStrategy
 * @Description 会话 策略
 * @Version 1.0
 */
public abstract class AbstractSessionStrategy {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    /** 跳转的目标 URL */
    private String destinationUrl;
    /** 系统配置 信息 */
    private SecurityProperties securityProperties;
    /** 跳转前是否创建新的 Session */
    private boolean createNewSession = true;
    /** 重定向 策略 */
    @Autowired
    private RedirectStrategy redirectStrategy;
    @Autowired
    private ObjectMapper objectMapper;

    public AbstractSessionStrategy(SecurityProperties securityProperties) {
        String invalidSessionUrl = securityProperties.getBrowser().getSession().getSessionInvalidUrl();
        Assert.isTrue(UrlUtils.isValidRedirectUrl(invalidSessionUrl), "url must start with '/' or with 'http(s)'");
        Assert.isTrue(StringUtils.endsWithIgnoreCase(invalidSessionUrl,".html"), "url must end with '.html'");
        this.destinationUrl = invalidSessionUrl;
        this.securityProperties = securityProperties;
    }


    /** 是否 创建新 Session 会话 */
    public void setCreateNewSession(boolean createNewSession) {
        this.createNewSession = createNewSession;
    }

    /** 是否 并发导致的 Session失效 */
    protected boolean isConcurrency() {
        return false;
    }

    /** 响应消息内容 */
    protected Object buildResponseContent(HttpServletRequest request) {
        return ResponseData.setResult(ResponseCode.SESSION_INVALIDE);
    }

    /** Session 会话失效 */
    protected void onSessionInvalid(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.logger.info("session失效");
        if (this.createNewSession) {
            request.getSession();
        }

        String sourceUrl = request.getRequestURI();
        if (StringUtils.endsWithIgnoreCase(sourceUrl,".html")) {
            String targetUrl;
            if (!StringUtils.equals(sourceUrl,this.securityProperties.getBrowser().getSignInPage()) &&
                    !StringUtils.equals(sourceUrl,this.securityProperties.getBrowser().getSignOutUrl())) {
                targetUrl = this.destinationUrl;
            } else {
                targetUrl = sourceUrl;
            }
            this.logger.info("跳转到：" + targetUrl);
            this.redirectStrategy.sendRedirect(request,response,targetUrl);
        } else {
            Object result = this.buildResponseContent(request);
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            response.setContentType(CommonConstants.HTTP_CONTENT_TYPE_JSON);
            response.getWriter().write(this.objectMapper.writeValueAsString(result));
        }
    }
}
