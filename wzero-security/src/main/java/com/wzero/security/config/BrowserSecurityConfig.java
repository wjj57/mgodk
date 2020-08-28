package com.wzero.security.config;

import com.wzero.security.authentication.mobile.SmsCodeSecurityConfigurerAdapter;
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


    /** http.addFilterBefore(this.validateCodeFilter, AbstractPreAuthenticatedProcessingFilter.class); */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //super.configure(http);
        http
            //基础配置
            .formLogin()
                .loginPage(CommonConstants.DEFAULT_UNAUTHENTICATION_URL)
                .loginProcessingUrl(CommonConstants.DEFAULT_LOGIN_FORM_URL)
                .successHandler(this.authenticationSuccessHandler)
                .failureHandler(this.authenticationFailureHandler)
            .and().logout()
                .logoutUrl(this.securityProperties.getBrowser().getSignOutUrl())
                .logoutSuccessHandler(this.logoutSuccessHandler)
                .deleteCookies(new String[]{"JSESSIONID"})
            //适配器 - 验证 过滤器配置
            .and().apply(this.validateCodeSecurityConfigurerAdapter)
            .and().apply(this.smsCodeSecurityConfigurerAdapter)
            //记住我
            .and().rememberMe()
                .tokenRepository(this.persistentTokenRepository)
                .tokenValiditySeconds(this.securityProperties.getBrowser().getRememberMeSeconds())
                .userDetailsService(this.userDetailsService)
            //Session 会话配置
            .and().sessionManagement()
                .invalidSessionStrategy(this.invalidSessionStrategy)
                .maximumSessions(this.securityProperties.getBrowser().getSession().getMaximumSessions())
                .maxSessionsPreventsLogin(this.securityProperties.getBrowser().getSession().isPreventsLogin())
                .expiredSessionStrategy(this.sessionInformationExpiredStrategy)
                .sessionRegistry(this.sessionRegistry)
            .and()
            //授权配置
            .and().authorizeRequests()
                .antMatchers(
                        CommonConstants.DEFAULT_UNAUTHENTICATION_URL,
                        CommonConstants.DEFAULT_LOGIN_MOBILE_URL,
                        CommonConstants.DEFAULT_VALIDATE_CODE_URL_PREFIX + "/*",
                        this.securityProperties.getBrowser().getSignInPage(),
                        this.securityProperties.getBrowser().getSignUpUrl(),
//                        this.securityProperties.getBrowser().getSignOutUrl(),
                        this.securityProperties.getBrowser().getSession().getSessionInvalidUrl(),
                        this.securityProperties.getBrowser().getSession().getSessionInvalidUrl() + ".json",
                        this.securityProperties.getBrowser().getSession().getSessionInvalidUrl() + ".html"
                )
                .permitAll()
                .anyRequest()
                .authenticated()
            //取消跨站请求伪造防护
            .and().csrf()
                .disable();
    }
}
