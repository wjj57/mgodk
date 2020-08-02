package com.wzero.security.authorize;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;

/**
 * @ClassName IAuthorizeConfigProvider
 * @Description 授权配置提供者
 * @Author WJJ
 * @Date 2020/08/02 21:17
 * @Version 1.0
 */
public interface IAuthorizeConfigProvider {
    boolean config(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry urlRegistry);
}