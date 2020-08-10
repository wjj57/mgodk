package com.wzero.security.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wzero.security.authentication.MyAuthenticationFailureHandler;
import com.wzero.security.authentication.MyAuthenticationSuccessHandler;
import com.wzero.security.authentication.MyLogoutSuccessHandler;
import com.wzero.security.authentication.mobile.SmsCodeSecurityConfigurerAdapter;
import com.wzero.security.authorize.AuthorizeConfigManager;
import com.wzero.security.authorize.AuthorizeConfigProvider;
import com.wzero.security.authorize.MyAuthorizeConfigManager;
import com.wzero.security.authorize.MyAuthorizeConfigProvider;
import com.wzero.security.properties.SecurityProperties;
import com.wzero.security.validate.ValidateCodeGenerator;
import com.wzero.security.validate.ValidateCodeRepository;
import com.wzero.security.validate.image.ImageCodeGenerator;
import com.wzero.security.validate.image.ImageCodeProcessor;
import com.wzero.security.validate.impl.DefaultUserDetailsServiceImpl;
import com.wzero.security.validate.impl.SessionValidateCodeRepository;
import com.wzero.security.validate.sms.DefaultSmsCodeSender;
import com.wzero.security.validate.sms.SmsCodeGenerator;
import com.wzero.security.validate.sms.SmsCodeProcessor;
import com.wzero.security.validate.sms.SmsCodeSender;
import org.springframework.beans.factory.annotation.Autowired;
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
 * @Description 配置 Bean 组件
 * @Author WJJ
 * @Date 2020/7/29 10:23
 * @Version 1.0
 * 注：
 */
@Configuration
public class SecurityBeanConfig {
    @Autowired
    private SecurityProperties securityProperties;
    /** 需要添加的 Bean
     * FormAuthenticationConfig
     * ImageCodeGenerator ImageCodeProcessor
     * SmsCodeGenerator SmsCodeProcessor SmsCodeSender
     * validateCodeGenerators validateCodeRepository validateCodeGenerators
     * authorizeConfigProviders BrowserAuthorizeConfigProvider MyAuthorizeConfigProvider
     */
    public AuthorizeConfigProvider authorizeConfigProvider() {
        return new MyAuthorizeConfigProvider();
    }
    public AuthorizeConfigManager authorizeConfigManager() {
        return new MyAuthorizeConfigManager();
    }
    public ValidateCodeRepository validateCodeRepository() {
        return new SessionValidateCodeRepository();
    }
    public ImageCodeProcessor imageValidateCodeProcessor() {
        return new ImageCodeProcessor();
    }
    public ValidateCodeGenerator imageValidateCodeGenerator() {
        return new ImageCodeGenerator();
    }
    public SmsCodeProcessor smsValidateCodeProcessor() {
        return new SmsCodeProcessor();
    }
    public ValidateCodeGenerator smsValidateCodeGenerator() {
        return new SmsCodeGenerator();
    }
    public SmsCodeSender smsCodeSender() {
        return new DefaultSmsCodeSender();
    }



    /** 配置 JSON 工具 */
    @Bean
    @ConditionalOnMissingBean({ObjectMapper.class})
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

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