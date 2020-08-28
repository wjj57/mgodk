package com.wzero.security.session;

import com.wzero.security.properties.SecurityProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.session.InvalidSessionStrategy;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName MyInvalidSessionStrategy
 * @Description 无效的 会话 策略
 * @Version 1.0
 * 注：默认 Session 失效 处理策略
 */
public class MyInvalidSessionStrategy extends AbstractSessionStrategy implements InvalidSessionStrategy {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public MyInvalidSessionStrategy(SecurityProperties securityProperties) {
        super(securityProperties);
    }

    @Override
    public void onInvalidSessionDetected(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException, ServletException {
        this.logger.info("Session 失效 ......");
        this.onSessionInvalid(httpServletRequest,httpServletResponse);
    }
}
