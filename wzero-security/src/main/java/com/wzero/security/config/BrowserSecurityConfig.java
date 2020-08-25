package com.wzero.security.config;

import com.wzero.security.authentication.mobile.SmsCodeSecurityConfigurerAdapter;
import com.wzero.security.authorize.AuthorizeConfigManager;
import com.wzero.security.authorize.AuthorizeConfigProvider;
import com.wzero.security.model.CommonConstants;
import com.wzero.security.properties.SecurityProperties;
import com.wzero.security.validate.ValidateCodeSecurityConfigurerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.session.InvalidSessionStrategy;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;

/**
 * @ClassName BrowserSecurityConfig
 * @Description 自定义 security  配置，
 * @Version 1.0
 */
@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private SecurityProperties securityProperties;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private AuthenticationSuccessHandler authenticationSuccessHandler;
    @Autowired
    private AuthenticationFailureHandler authenticationFailureHandler;
    @Autowired
    private LogoutSuccessHandler logoutSuccessHandler;

    @Autowired
    private SmsCodeSecurityConfigurerAdapter smsCodeSecurityConfigurerAdapter;
    @Autowired
    private ValidateCodeSecurityConfigurerAdapter validateCodeSecurityConfigurerAdapter;

    @Autowired
    private SessionRegistry sessionRegistry;
    @Autowired
    private InvalidSessionStrategy invalidSessionStrategy;
    @Autowired
    private SessionInformationExpiredStrategy sessionInformationExpiredStrategy;

    @Autowired
    private PersistentTokenRepository persistentTokenRepository;
    @Autowired
    private AuthorizeConfigProvider authorizeConfigProvider;
    @Autowired
    private AuthorizeConfigManager authorizeConfigManager;


    /** http.addFilterBefore(this.validateCodeFilter, AbstractPreAuthenticatedProcessingFilter.class); */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //super.configure(http);
        http
            //基础配置
            .formLogin()
                .loginPage(CommonConstants.DEFAULT_UNAUTHENTICATION_URL)
                .loginProcessingUrl(CommonConstants.DEFAULT_LOGIN_FORM_URL)
                .successHandler(authenticationSuccessHandler)
                .failureHandler(authenticationFailureHandler)
            .and().logout()
                .logoutSuccessHandler(logoutSuccessHandler)
                .deleteCookies(new String[]{"JSESSIONID"})
            //适配器 - 验证 过滤器配置
            .and().apply(validateCodeSecurityConfigurerAdapter)
            .and().apply(smsCodeSecurityConfigurerAdapter)
            //记住我
            .and().rememberMe()
                .tokenRepository(persistentTokenRepository)
                .tokenValiditySeconds(securityProperties.getBrowser().getRememberMeSeconds())
                .userDetailsService(userDetailsService)
            //Session 会话配置
            .and().sessionManagement()
                .invalidSessionStrategy(invalidSessionStrategy)
                .maximumSessions(securityProperties.getBrowser().getSession().getMaximumSessions())
                .maxSessionsPreventsLogin(securityProperties.getBrowser().getSession().isPreventsLogin())
                .expiredSessionStrategy(sessionInformationExpiredStrategy)
                .sessionRegistry(sessionRegistry)
            .and()
            //授权配置
            .and().authorizeRequests()
                .antMatchers(
                        CommonConstants.DEFAULT_UNAUTHENTICATION_URL,
                        CommonConstants.DEFAULT_LOGIN_MOBILE_URL,
                        CommonConstants.DEFAULT_VALIDATE_CODE_URL_PREFIX + "/*",
                        securityProperties.getBrowser().getSignInPage(),
                        securityProperties.getBrowser().getSession().getSessionInvalidUrl() + ".json",
                        securityProperties.getBrowser().getSession().getSessionInvalidUrl() + ".html"
                )
                .permitAll()
                .anyRequest()
                .authenticated()
            //取消跨站请求伪造防护
            .and().csrf()
                .disable();
    }
}
