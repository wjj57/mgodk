package com.wzero.security.controller;

import com.wzero.security.properties.SecurityProperties;
import com.wzero.security.validate.ValidateCodeProcessorHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName LoginController
 * @Description 登录相关请求处理
 * @Version 1.0
 */
@RestController
public class LoginController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private RequestCache requestCache = new HttpSessionRequestCache();

    @Autowired
    private RedirectStrategy redirectStrategy;
    @Autowired
    private SecurityProperties securityProperties;
    @Autowired
    private ValidateCodeProcessorHolder validateCodeProcessorHolder;


    @RequestMapping("/authentication/require")
    public void requireAuthentication(HttpServletRequest request, HttpServletResponse response) throws Exception {
        SavedRequest savedRequest = this.requestCache.getRequest(request, response);
        if (savedRequest != null) {
            String targetUrl = savedRequest.getRedirectUrl();
            this.logger.info("引发跳转的请求是：" + targetUrl);
            if (StringUtils.endsWithIgnoreCase(targetUrl, ".html")) {
                this.redirectStrategy.sendRedirect(request, response, targetUrl.substring(targetUrl.lastIndexOf("/")+1));
            } else {
                this.redirectStrategy.sendRedirect(request, response, this.securityProperties.getBrowser().getSignInPage());
            }
        } else {
            this.redirectStrategy.sendRedirect(request, response, this.securityProperties.getBrowser().getSignInPage());
        }
    }

    @GetMapping("/code/{type}")//validate sms image
    public void createCode(@PathVariable(value = "type") String type,HttpServletRequest request, HttpServletResponse response) throws Exception {
        this.validateCodeProcessorHolder.findValidateCodeProcessor(type).create(new ServletWebRequest(request, response));
    }

}
