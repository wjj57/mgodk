package com.wzero.security.authentication;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wzero.security.model.CommonConstants;
import com.wzero.security.model.ResponseData;
import com.wzero.security.model.ResponseType;
import com.wzero.security.properties.SecurityProperties;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName MyAuthenticationSuccessHandler
 * @Description 自定义 登录成功处理器
 * @Version 1.0
 * 可以直接实现 AuthenticationSuccessHandler；
 * 或继承其子类 SimpleUrlAuthenticationSuccessHandler -> SavedRequestAwareAuthenticationSuccessHandler
 */
public class MyAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private SecurityProperties securityProperties;

    private RequestCache requestCache = new HttpSessionRequestCache();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        this.logger.info("自定义：登录成功");

        if (ResponseType.JSON.equals(this.securityProperties.getBrowser().getSignInResponseType())) {
            response.setContentType(CommonConstants.HTTP_CONTENT_TYPE_JSON);
            response.getWriter().write(this.objectMapper.writeValueAsString(ResponseData.ok().data("登录成功！")));
        } else {
            if (StringUtils.isNotBlank(this.securityProperties.getBrowser().getSingInSuccessUrl())) {
                this.requestCache.removeRequest(request,response);
                setAlwaysUseDefaultTargetUrl(true);
                setDefaultTargetUrl(this.securityProperties.getBrowser().getSingInSuccessUrl());
            }
            super.onAuthenticationSuccess(request,response,authentication);
        }
    }
}
