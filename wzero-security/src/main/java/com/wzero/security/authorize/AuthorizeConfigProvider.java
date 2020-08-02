package com.wzero.security.authorize;

import com.wzero.security.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer.AuthorizedUrl;

/**
 * @ClassName AuthorizeConfigProvider
 * @Description 授权配置 提供程序
 * @Author WJJ
 * @Date 2020/08/02 21:25
 * @Version 1.0
 */
public class AuthorizeConfigProvider implements IAuthorizeConfigProvider {
    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public boolean config(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry urlRegistry) {
        String[] matchers = new String[]{
                "/authentication/require", "/authentication/mobile", "/authentication/openid", "/code/*",
                this.securityProperties.getBrowser().getSignInPage(),
                this.securityProperties.getBrowser().getSignUpUrl(),
                this.securityProperties.getBrowser().getSession().getSessionInvalidUrl()
        };
        ((AuthorizedUrl)urlRegistry.antMatchers(matchers)).permitAll();
        return false;
    }
}
