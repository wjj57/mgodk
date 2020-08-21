package com.wzero.security.validate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;

/**
 * @ClassName ValidateCodeSecurityConfigurerAdapter
 * @Description 自定义 验证过滤
 * @Author WJJ
 * @Date 2020/08/20 17:54
 * @Version 1.0
 * 注：继承 SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity>，并注解标注为组件
 */
public class ValidateCodeSecurityConfigurerAdapter extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {
    @Autowired
    private ValidateCodeFilter validateCodeFilter;

    @Override
    public void configure(HttpSecurity builder) throws Exception {
        //super.configure(builder);
        builder.addFilterBefore(this.validateCodeFilter, AbstractPreAuthenticatedProcessingFilter.class);
    }
}
