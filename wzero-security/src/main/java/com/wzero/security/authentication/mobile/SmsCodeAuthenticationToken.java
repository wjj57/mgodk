package com.wzero.security.authentication.mobile;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;
import java.util.Collection;

/**
 * @ClassName SmsCodeAuthenticationToken
 * @Description 自定义 短信验证 Token
 * @Author WJJ
 * @Date 2020/7/27 15:20
 * @Version 1.0
 * 注：参照 UsernamePasswordAuthenticationToken 编写
 */
public class SmsCodeAuthenticationToken extends AbstractAuthenticationToken implements Serializable {
    private static final long serialVersionUID = -98L;
    /** 该属性没登录前放手机号，登录后的放用户信息 */
    private final Object principal;

    public SmsCodeAuthenticationToken(String mobile) {
        super((Collection)null);
        this.principal = mobile;
        this.setAuthenticated(false);
    }

    /**Creates a token with the supplied array of authorities.
     * @param authorities the collection of <tt>GrantedAuthority</tt>s for the principal
     *                    represented by this authentication object.
     */
    public SmsCodeAuthenticationToken(Object principal, Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.principal = principal;
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return null;
    }

    @Override
    public void setAuthenticated(boolean authenticated) {
        super.setAuthenticated(authenticated);
    }

    @Override
    public void eraseCredentials() {
        super.eraseCredentials();
    }
}
