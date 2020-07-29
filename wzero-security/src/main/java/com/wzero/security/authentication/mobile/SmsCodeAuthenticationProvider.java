package com.wzero.security.authentication.mobile;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @ClassName SmsCodeAuthenticationProvider
 * @Description 自定义 短信验证 Provider
 * @Author WJJ
 * @Date 2020/7/28 17:36
 * @Version 1.0
 * 注：参照 DaoAuthenticationProvider 编写
 */
public class SmsCodeAuthenticationProvider implements AuthenticationProvider {
    private UserDetailsService userDetailsService;

    public SmsCodeAuthenticationProvider() {}

    /** 进行身份认证的逻辑 */
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        SmsCodeAuthenticationToken authenticationToken = (SmsCodeAuthenticationToken)authentication;
        UserDetails user = this.userDetailsService.loadUserByUsername((String)authenticationToken.getPrincipal());
        if (user == null) {
            throw new InternalAuthenticationServiceException("无法获取用户信息");
        } else {
            SmsCodeAuthenticationToken authenticationResult = new SmsCodeAuthenticationToken(user, user.getAuthorities());
            authenticationResult.setDetails(authenticationToken.getDetails());
            return authenticationResult;
        }
    }

    /** 根据该方法判断 AuthenticationManager选择哪个 Provider进行认证处理 */
    @Override
    public boolean supports(Class<?> authentication) {
        return SmsCodeAuthenticationToken.class.isAssignableFrom(authentication);
    }

    public UserDetailsService getUserDetailsService() {
        return userDetailsService;
    }
    public void setUserDetailsService(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }
}
