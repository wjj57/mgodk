package com.wzero.security.authorize;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer.AuthorizedUrl;

/**
 * @ClassName BrowserAuthorizeConfigProvider
 * @Description 授权配置 提供程序
 * @Author WJJ
 * @Date 2020/08/02 21:15
 * @Version 1.0
 */
public class BrowserAuthorizeConfigProvider implements IAuthorizeConfigProvider {
    @Override
    public boolean config(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry urlRegistry) {
        String[] matchers = new String[]{
                "/**/*.js", "/**/*.css",
                "/**/*.jpg", "/**/*.png", "/**/*.gif"
        };
        ((AuthorizedUrl)urlRegistry.antMatchers(HttpMethod.GET,matchers)).permitAll();
        return false;
    }
}
