package com.wzero.security.authentication;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wzero.security.model.CommonConstants;
import com.wzero.security.model.ResponseData;
import com.wzero.security.model.ResponseType;
import com.wzero.security.model.pojo.SecurityUserDetails;
import com.wzero.security.properties.SecurityProperties;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName MyLogoutSuccessHandler
 * @Description 自定义 注销退出成功处理器
 * @Version 1.0
 * 可以直接实现 LogoutSuccessHandler；
 * 或继承其子类 SimpleUrlAuthenticationFailureHandler
 */
public class MyLogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private SecurityProperties securityProperties;
    private RequestCache requestCache = new HttpSessionRequestCache();

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        logger.info("退出登录成功 .......... .....");
        SecurityUserDetails userDetails = (SecurityUserDetails) authentication.getPrincipal();
        request.setAttribute("userName",userDetails.getUsername());

        if (ResponseType.JSON.equals(this.securityProperties.getBrowser().getSignInResponseType())
                || StringUtils.isBlank(this.securityProperties.getBrowser().getSignOutUrl()) ) {
            response.setContentType(CommonConstants.HTTP_CONTENT_TYPE_JSON);
            response.getWriter().write(this.objectMapper.writeValueAsString(ResponseData.ok().data("退出成功！")));
        } else {
            response.sendRedirect(this.securityProperties.getBrowser().getSignOutUrl());
        }
    }
}
