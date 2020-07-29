package com.wzero.security.config;

import com.wzero.security.authentication.MyAuthenticationFailureHandler;
import com.wzero.security.authentication.MyAuthenticationSuccessHandler;
import com.wzero.security.authentication.MyLogoutSuccessHandler;
import com.wzero.security.authentication.mobile.SmsCodeSecurityConfigurerAdapter;
import com.wzero.security.service.DefaultUserDetailsServiceImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

/**
 * @ClassName SecurityBeanConfig
 * @Description 配置需要注入的 Bean 组件
 * @Author WJJ
 * @Date 2020/7/29 10:23
 * @Version 1.0
 * 注：
 * success,failure,service,SmsCodeSecurityConfigurerAdapter
 */
@Configuration
public class SecurityBeanConfig {
    /** 配置 登录成功处理器 */
    @Bean
    @ConditionalOnMissingBean({AuthenticationSuccessHandler.class})
    public AuthenticationSuccessHandler authenticationSuccessHandler() {
        return new MyAuthenticationSuccessHandler();
    }
    /** 配置 登录失败处理器 */
    @Bean
    @ConditionalOnMissingBean({AuthenticationFailureHandler.class})
    public AuthenticationFailureHandler authenticationFailureHandler() {
        return new MyAuthenticationFailureHandler();
    }
    /** 配置 登出成功处理器 */
    @Bean
    @ConditionalOnMissingBean({LogoutSuccessHandler.class})
    public LogoutSuccessHandler logoutSuccessHandler() {
        return new MyLogoutSuccessHandler();
    }
    /** 配置 用户登录验证处理逻辑 */
    @Bean
    @ConditionalOnMissingBean({UserDetailsService.class})
    public UserDetailsService userDetailsService() {
        return new DefaultUserDetailsServiceImpl();
    }
    /** 配置 密码加密方式 */
    @Bean
    @ConditionalOnMissingBean({PasswordEncoder.class})
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /** 配置 短信验证的单独配置 */
    @Bean
    public SmsCodeSecurityConfigurerAdapter smsCodeSecurityConfigurerAdapter() {
        return new SmsCodeSecurityConfigurerAdapter();
    }
    /** 配置 记住我设置功能 */
    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
//        tokenRepository.
        tokenRepository.setCreateTableOnStartup(true);
        return tokenRepository;
    }
}