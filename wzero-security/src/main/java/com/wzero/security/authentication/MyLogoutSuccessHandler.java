package com.wzero.security.authentication;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName MyLogoutSuccessHandler
 * @Description 自定义 注销退出成功处理器
 * @Author WJJ
 * @Date 2020/7/21 17:30
 * @Version 1.0
 * 可以直接实现 LogoutSuccessHandler；
 * 或继承其子类 SimpleUrlAuthenticationFailureHandler
 */
public class MyLogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private ObjectMapper objectMapper = new ObjectMapper();

    public MyLogoutSuccessHandler() {}

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        logger.info("退出登录成功.......... .....");
        boolean flag = true;
        if (flag) {
            Map<String,Object> map = new HashMap<>();
            map.put("success",true);
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(objectMapper.writeValueAsString(map));
            //response.sendRedirect("/loginPage");
        } else {
            super.onLogoutSuccess(request, response, authentication);
        }
    }
}
