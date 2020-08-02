package com.wzero.security.authorize;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer.AuthorizedUrl;

import java.util.Iterator;
import java.util.List;

/**
 * @ClassName AuthorizeConfigManager
 * @Description 授权配置 管理器
 * @Author WJJ
 * @Date 2020/08/02 21:26
 * @Version 1.0
 */
public class AuthorizeConfigManager implements IAuthorizeConfigManager {
    @Autowired
    private List<IAuthorizeConfigProvider> authorizeConfigProviders;

    @Override
    public void config(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry urlRegistry) {
        boolean existAnyRequestConfig = false;
        String existAnyRequestConfigName = null;
        Iterator iterator = this.authorizeConfigProviders.iterator();
        while (iterator.hasNext()) {
            IAuthorizeConfigProvider authorizeConfigProvider = (IAuthorizeConfigProvider)iterator.next();
            boolean currentIsAnyRequestConfig = authorizeConfigProvider.config(urlRegistry);
            if (existAnyRequestConfig && currentIsAnyRequestConfig)  {
                throw new RuntimeException("重复的anyRequest配置:" + existAnyRequestConfigName + ","
                        + authorizeConfigProvider.getClass().getSimpleName());
            }
            if (currentIsAnyRequestConfig) {
                existAnyRequestConfig = true;
                existAnyRequestConfigName = authorizeConfigProvider.getClass().getSimpleName();
            }
        }
        if (!existAnyRequestConfig) {
            ((AuthorizedUrl)urlRegistry.anyRequest()).authenticated();
        }
    }
}
