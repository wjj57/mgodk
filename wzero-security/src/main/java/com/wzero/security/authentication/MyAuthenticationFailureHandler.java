package com.wzero.security.authentication;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wzero.security.exception.ValidateCodeException;
import com.wzero.security.model.CommonConstants;
import com.wzero.security.model.ResponseType;
import com.wzero.security.properties.SecurityProperties;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.session.SessionAuthenticationException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName MyAuthenticationFailureHandler
 * @Description 自定义 登录失败处理器
 * @Version 1.0
 * 可以直接实现 AuthenticationFailureHandler；
 * 或继承其子类 SimpleUrlAuthenticationFailureHandler
 */
public class MyAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        //ResponseCode 自定义响应异常数据
//        if (exception instanceof ValidateCodeException) {
//        }else if (exception instanceof UsernameNotFoundException) {
//        }else if (exception instanceof BadCredentialsException) {
//        } else if (exception instanceof SessionAuthenticationException) {
//        }
        logger.info("自定义：登录失败");
        if (ResponseType.JSON.equals(securityProperties.getBrowser().getSignInResponseType())) {
            response.setContentType(CommonConstants.HTTP_CONTENT_TYPE_JSON);
            response.getWriter().write(objectMapper.writeValueAsString(exception));
        } else {
            super.onAuthenticationFailure(request,response,exception);
        }
    }
}
