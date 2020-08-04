package com.wzero.security.authentication;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wzero.security.model.CommonConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName MyAuthenticationFailureHandler
 * @Description 自定义 登录失败处理器
 * @Author WJJ
 * @Date 2020/7/21 16:18
 * @Version 1.0
 * 可以直接实现 AuthenticationFailureHandler；
 * 或继承其子类 SimpleUrlAuthenticationFailureHandler
 */
public class MyAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ObjectMapper objectMapper;

    public MyAuthenticationFailureHandler() {}

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        logger.info("登录失败");
        boolean flag = true;
        if (flag) {
            Map<String,Object> map = new HashMap<>();
            map.put("success",true);
            response.setContentType(CommonConstants.HTTP_CONTENT_TYPE_JSON);
            response.getWriter().write(objectMapper.writeValueAsString(map));
        } else {
            super.onAuthenticationFailure(request, response, exception);
        }
    }
}
