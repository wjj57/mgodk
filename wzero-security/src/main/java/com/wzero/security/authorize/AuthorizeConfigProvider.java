package com.wzero.security.authorize;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;

/**
 * @ClassName AuthorizeConfigProvider
 * @Description 授权配置提供者
 * @Version 1.0
 */
public interface AuthorizeConfigProvider {
    boolean config(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry urlRegistry);
}
