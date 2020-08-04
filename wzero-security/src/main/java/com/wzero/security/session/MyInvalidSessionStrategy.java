package com.wzero.security.session;

import com.wzero.security.properties.SecurityProperties;
import org.springframework.security.web.session.InvalidSessionStrategy;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName MyInvalidSessionStrategy
 * @Description 无效的 会话 策略
 * @Author WJJ
 * @Date 2020/08/03 15:27
 * @Version 1.0
 * 注：默认 Session 失效 处理策略
 */
public class MyInvalidSessionStrategy extends AbstractSessionStrategy implements InvalidSessionStrategy {
    public MyInvalidSessionStrategy(SecurityProperties securityProperties) {
        super(securityProperties);
    }

    @Override
    public void onInvalidSessionDetected(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException, ServletException {
        this.onSessionInvalid(httpServletRequest,httpServletResponse);
    }
}
