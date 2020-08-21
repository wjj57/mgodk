package com.wzero.security.authentication.mobile;

import com.wzero.security.model.CommonConstants;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.util.Assert;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName SmsCodeAuthenticationFilter
 * @Description 自定义 短信验证 Filter，验证用户
 * @Author WJJ
 * @Date 2020/7/28 16:26
 * @Version 1.0
 * 注：参照 UsernamePasswordAuthenticationToken 编写
 */
public class SmsCodeAuthenticationFilter extends AbstractAuthenticationProcessingFilter {
    private boolean postOnly = true;
    private String mobileParameter = CommonConstants.DEFAULT_PARAMETER_NAME_MOBILE;

    public SmsCodeAuthenticationFilter() {
        //super(new AntPathRequestMatcher("/authentication/mobile","POST"));
        super(new AntPathRequestMatcher(CommonConstants.DEFAULT_LOGIN_MOBILE_URL,CommonConstants.HTTP_METHOD_POST));
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
        if (this.postOnly && !CommonConstants.HTTP_METHOD_POST.equals(request.getMethod())) {
            throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
        } else {
            String mobile = this.obtainMobile(request);
            if (mobile == null) {
                mobile = "";
            }
            mobile = mobile.trim();
            // 生成token
            SmsCodeAuthenticationToken authRequest = new SmsCodeAuthenticationToken(mobile);
            this.setDetails(request, authRequest);
            // 调用 AuthenticationManager
            return this.getAuthenticationManager().authenticate(authRequest);
        }
    }

    /** 获取手机号 */
    protected String obtainMobile(HttpServletRequest request) {
        return request.getParameter(this.mobileParameter);
    }

    protected void setDetails(HttpServletRequest request, SmsCodeAuthenticationToken authRequest) {
        authRequest.setDetails(this.authenticationDetailsSource.buildDetails(request));
    }

    public final String getMobileParameter() {
        return this.mobileParameter;
    }

    public void setMobileParameter(String usernameParameter) {
        Assert.hasText(usernameParameter, "Username parameter must not be empty or null");
        this.mobileParameter = usernameParameter;
    }

    public void setPostOnly(boolean postOnly) {
        this.postOnly = postOnly;
    }
}
