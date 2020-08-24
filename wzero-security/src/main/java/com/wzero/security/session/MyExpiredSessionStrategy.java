package com.wzero.security.session;

import com.wzero.security.properties.SecurityProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.session.SessionInformationExpiredEvent;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * @ClassName MyExpiredSessionStrategy
 * @Description 过期的 会话 策略
 * @Version 1.0
 * 注：并发登录导致 Session 失效时，默认处理策略
 */
public class MyExpiredSessionStrategy extends AbstractSessionStrategy implements SessionInformationExpiredStrategy {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public MyExpiredSessionStrategy(SecurityProperties securityProperties) {
        super(securityProperties);
    }

    @Override
    protected boolean isConcurrency() {
        return true;
    }

    @Override
    public void onExpiredSessionDetected(SessionInformationExpiredEvent sessionInformationExpiredEvent) throws IOException, ServletException {
        logger.info("Session 过期 ......");
        onSessionInvalid(sessionInformationExpiredEvent.getRequest(), sessionInformationExpiredEvent.getResponse());
    }
}
