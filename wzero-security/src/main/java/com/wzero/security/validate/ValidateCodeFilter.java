package com.wzero.security.validate;

import com.wzero.security.exception.ValidateCodeException;
import com.wzero.security.model.CommonConstants;
import com.wzero.security.properties.SecurityProperties;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName ValidateCodeFilter
 * @Description 验证码 过滤器
 * @Author WJJ
 * @Date 2020/08/03 17:49
 * @Version 1.0
 */
public class ValidateCodeFilter extends OncePerRequestFilter implements InitializingBean {
    @Autowired
    private AuthenticationFailureHandler authenticationFailureHandler;
    @Autowired
    private SecurityProperties securityProperties;
    @Autowired
    private ValidateCodeProcessorHolder validateCodeProcessorHolder;
    private Map<String, ValidateCodeType> urlMap = new HashMap();
    private AntPathMatcher pathMatcher = new AntPathMatcher();

    protected void addUrlToMap(String urlString, ValidateCodeType codeType) {
        if (StringUtils.isNotBlank(urlString)) {
            String[] urls = StringUtils.splitByWholeSeparatorPreserveAllTokens(urlString, ",");
            for (int i = 0; i < urls.length; i++) {
                urlMap.put(urls[i],codeType);
            }
        }
    }

    private ValidateCodeType getValidateCodeType(HttpServletRequest servletRequest) {
        ValidateCodeType codeType = null;
        if (!StringUtils.equalsIgnoreCase(servletRequest.getMethod(), CommonConstants.HTTP_METHOD_GET)) {
            Set<String> urls = urlMap.keySet();
            Iterator<String> iterator = urls.iterator();
            while (iterator.hasNext()) {
                String url = iterator.next();
                if (pathMatcher.match(url,servletRequest.getRequestURI())) {
                    codeType = urlMap.get(url);
                }
            }
        }
        return codeType;
    }

    @Override
    public void afterPropertiesSet() throws ServletException {
        super.afterPropertiesSet();
        if (StringUtils.isBlank(securityProperties.getValidateCode().getImage().getUrl())) {
            urlMap.put("/authentication/form", ValidateCodeType.IMAGE);
            addUrlToMap(securityProperties.getValidateCode().getImage().getUrl(), ValidateCodeType.IMAGE);
            urlMap.put("/authentication/mobile", ValidateCodeType.SMS);
            addUrlToMap(securityProperties.getValidateCode().getSms().getUrl(), ValidateCodeType.SMS);
        }
    }
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        ValidateCodeType codeType = getValidateCodeType(httpServletRequest);
        if (codeType != null) {
            this.logger.info("校验请求(" + httpServletRequest.getRequestURI() + ")中的验证码,验证码类型" + codeType);
            try {
                validateCodeProcessorHolder.findValidateCodeProcessor(codeType)
                        .validate(new ServletWebRequest(httpServletRequest,httpServletResponse));
                this.logger.info("验证码校验通过");
            } catch (ValidateCodeException e) {
                authenticationFailureHandler.onAuthenticationFailure(httpServletRequest,httpServletResponse,e);
                return;
            }
        }
        filterChain.doFilter(httpServletRequest,httpServletResponse);
    }
}
