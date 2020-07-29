package com.wzero.security.authentication;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName MyAuthenticationSuccessHandler
 * @Description 自定义 登录成功处理器
 * @Author WJJ
 * @Date 2020/7/21 16:17
 * @Version 1.0
 * 可以直接实现 AuthenticationSuccessHandler；
 * 或继承其子类 SimpleUrlAuthenticationSuccessHandler -> SavedRequestAwareAuthenticationSuccessHandler
 */
public class MyAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private ObjectMapper objectMapper = new ObjectMapper();
    private RequestCache requestCache = new HttpSessionRequestCache();

    public MyAuthenticationSuccessHandler() {}

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        logger.info("登录成功");
        boolean flag = true;
        if (flag) {
            Map<String,Object> map = new HashMap<>();
            map.put("success",true);
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(objectMapper.writeValueAsString(map));
        } else {
            super.onAuthenticationSuccess(request, response, authentication);
        }
    }
}
