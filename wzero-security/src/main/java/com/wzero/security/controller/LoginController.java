package com.wzero.security.controller;

import com.wzero.security.model.ReturnResult;
import com.wzero.security.properties.SecurityProperties;
import com.wzero.security.validate.ValidateCodeGenerator;
import com.wzero.security.validate.ValidateCodeProcessorHolder;
import com.wzero.security.validate.image.ImageCode;
import com.wzero.security.validate.image.ImageCodeGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.DefaultRedirectStrategy;
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

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName LoginController
 * @Description 登录相关请求处理
 * @Author WJJ
 * @Date 2020/08/20 10:57
 * @Version 1.0
 */
@RestController
public class LoginController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private RequestCache requestCache = new HttpSessionRequestCache();

    @Autowired
    private SecurityProperties securityProperties;
    @Autowired
    private ValidateCodeProcessorHolder validateCodeProcessorHolder;
    @Autowired
    private ImageCodeGenerator imageCodeGenerator;//ValidateCodeGenerator
    @Autowired
    private RedirectStrategy redirectStrategy;// = new DefaultRedirectStrategy()


    @RequestMapping("/authentication/require")
    public ReturnResult requireAuthentication(HttpServletRequest request, HttpServletResponse response) throws Exception{
        SavedRequest savedRequest = requestCache.getRequest(request, response);
        if (savedRequest != null) {
            String targetUrl = savedRequest.getRedirectUrl();
            logger.info("引发跳转的请求是:" + targetUrl);
            if (StringUtils.endsWithIgnoreCase(targetUrl, ".html")) {
                redirectStrategy.sendRedirect(request, response, securityProperties.getBrowser().getSignInPage());
            }
        }
        return ReturnResult.failure("访问的服务需要身份认证，请引导用户到登录页");
    }

    @GetMapping("/code/{type}")
    public void createCode(@PathVariable(value = "type") String type) throws Exception {}

    @GetMapping("/validate/code/sms")
    public void createCodeSms(HttpServletRequest request, HttpServletResponse response) throws Exception {
        validateCodeProcessorHolder.findValidateCodeProcessor("sms").create(new ServletWebRequest(request, response));
    }

    @GetMapping("/validate/code/image")
    public void createCodeImg(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ImageCode imageCode = (ImageCode)imageCodeGenerator.generate(new ServletWebRequest(request,response));
        ImageIO.write(imageCode.getImage(),"JPEG",response.getOutputStream());
    }
}
