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
import com.wzero.security.session.MyExpiredSessionStrategy;
import com.wzero.security.session.MyInvalidSessionStrategy;
import com.wzero.security.validate.ValidateCodeFilter;
import com.wzero.security.validate.ValidateCodeGenerator;
import com.wzero.security.validate.ValidateCodeProcessorHolder;
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
import org.springframework.security.web.session.InvalidSessionStrategy;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;

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
     * DataSource
     * ImageCodeGenerator ImageCodeProcessor
     * SmsCodeGenerator
     * validateCodeGenerators validateCodeRepository validateCodeGenerators
     * authorizeConfigProviders BrowserAuthorizeConfigProvider MyAuthorizeConfigProvider
     *
     * SmsCodeProcessor SmsCodeSender
     */
    /** 授权配置 提供程序 */
    @Bean
    @ConditionalOnMissingBean({AuthorizeConfigProvider.class})
    public AuthorizeConfigProvider authorizeConfigProvider() {
        return new MyAuthorizeConfigProvider();
    }
    /** 授权配置 管理器 */
    @Bean
    @ConditionalOnMissingBean({AuthorizeConfigManager.class})
    public AuthorizeConfigManager authorizeConfigManager() {
        return new MyAuthorizeConfigManager();
    }
    /** 会话 验证码 存储库 */
    @Bean
    @ConditionalOnMissingBean({ValidateCodeRepository.class})
    public ValidateCodeRepository validateCodeRepository() {
        return new SessionValidateCodeRepository();
    }
    /** 图片验证码 处理器 */
    @Bean
    @ConditionalOnMissingBean({ImageCodeProcessor.class})
    public ImageCodeProcessor imageValidateCodeProcessor() {
        return new ImageCodeProcessor();
    }
    /** 图片验证码 生成器 */
    @Bean
    @ConditionalOnMissingBean({ValidateCodeGenerator.class})
    public ValidateCodeGenerator imageValidateCodeGenerator() {
        return new ImageCodeGenerator();
    }
    /** 短信验证码 处理器 */
    @Bean
    @ConditionalOnMissingBean({SmsCodeProcessor.class})
    public SmsCodeProcessor smsValidateCodeProcessor() {
        return new SmsCodeProcessor();
    }
    /** 短信 验证码 生成器 */
    @Bean
    @ConditionalOnMissingBean({ValidateCodeGenerator.class})
    public ValidateCodeGenerator smsValidateCodeGenerator() {
        return new SmsCodeGenerator();
    }
    /** 发送 短信验证码 */
    @Bean
    @ConditionalOnMissingBean({SmsCodeSender.class})
    public SmsCodeSender smsCodeSender() {
        return new DefaultSmsCodeSender();
    }
    /** 验证码 过滤器 */
    @Bean
    @ConditionalOnMissingBean({ValidateCodeFilter.class})
    public ValidateCodeFilter validateCodeFilter() {
        return new ValidateCodeFilter();
    }
    /** 验证码 处理器 持有人 */
    @Bean
    @ConditionalOnMissingBean({ValidateCodeProcessorHolder.class})
    public ValidateCodeProcessorHolder validateCodeProcessorHolder() {
        return new ValidateCodeProcessorHolder();
    }
    /** 无效的 会话 策略 */
    @Bean
    @ConditionalOnMissingBean({InvalidSessionStrategy.class})
    public InvalidSessionStrategy invalidSessionStrategy() {
        return new MyInvalidSessionStrategy(securityProperties);
    }
    /** 过期的 会话 策略 */
    @Bean
    @ConditionalOnMissingBean({SessionInformationExpiredStrategy.class})
    public SessionInformationExpiredStrategy sessionInformationExpiredStrategy() {
        return new MyExpiredSessionStrategy(securityProperties);
    }

    /** 配置 短信验证的单独配置 */
    @Bean
    @ConditionalOnMissingBean({SmsCodeSecurityConfigurerAdapter.class})
    public SmsCodeSecurityConfigurerAdapter smsCodeSecurityConfigurerAdapter() {
        return new SmsCodeSecurityConfigurerAdapter();
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
    /** 配置 记住我设置功能 */
    @Bean
    @ConditionalOnMissingBean({PersistentTokenRepository.class})
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
//        tokenRepository.
        tokenRepository.setCreateTableOnStartup(true);
        return tokenRepository;
    }
}