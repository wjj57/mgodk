package com.wzero.security.authorize;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;

/**
 * @ClassName AuthorizeConfigManager
 * @Description 授权配置管理器
 * @Author WJJ
 * @Date 2020/08/02 21:21
 * @Version 1.0
 */
public interface AuthorizeConfigManager {
    void config(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry urlRegistry);
}
