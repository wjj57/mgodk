package com.wzero.security.config;

import com.wzero.security.authentication.mobile.SmsCodeSecurityConfigurerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.sql.DataSource;

/**
 * @ClassName BrowserSecurityConfig
 * @Description 自定义 security  配置，
 * @Author WJJ
 * @Date 2020/7/29 10:20
 * @Version 1.0
 */
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private AuthenticationSuccessHandler authenticationSuccessHandler;
    @Autowired
    private AuthenticationFailureHandler authenticationFailureHandler;
    @Autowired
    private LogoutSuccessHandler logoutSuccessHandler;
    @Autowired
    private DataSource dataSource;
    @Autowired
    private UserDetailsService userDetailsService;
    /** 短信验证的单独配置,通过HttpSecurity 的apply（）方法进行配置 */
    @Autowired
    private SmsCodeSecurityConfigurerAdapter smsCodeSecurityConfigurerAdapter;

    /** http.addFilterBefore(this.validateCodeFilter, AbstractPreAuthenticatedProcessingFilter.class); */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        ((HttpSecurity)http).csrf().disable();
    }
}
