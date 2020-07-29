package com.wzero.security.authentication.mobile;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName SmsCodeOncePerRequestFilter
 * @Description 自定义 短信验证 验证码验证过滤器
 * @Author WJJ
 * @Date 2020/07/28 22:28
 * @Version 1.0
 * 注：继承一个过滤器，实现验证码验证
 */
public class SmsCodeOncePerRequestFilter extends OncePerRequestFilter implements InitializingBean {
    private AuthenticationFailureHandler authenticationFailureHandler;
//    private SecurityProperties securityProperties;
//    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();
//    private Set<String> urls = new HashSet<>();
//    private AntPathMatcher pathMatcher = new AntPathMatcher();

    /** 登录 验证码过滤 */
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {

        filterChain.doFilter(httpServletRequest,httpServletResponse);
    }

    /** 初始化设置，将配置文件中的值读取，存在urls中 */
    @Override
    public void afterPropertiesSet() throws ServletException {
        super.afterPropertiesSet();
//        String[] configUrls = StringUtils.split(securityProperties.getCode().getSms().getUrl(),",");
    }
}
