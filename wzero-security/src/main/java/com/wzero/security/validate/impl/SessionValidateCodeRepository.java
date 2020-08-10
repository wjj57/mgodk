package com.wzero.security.validate.impl;

import com.wzero.security.validate.ValidateCode;
import com.wzero.security.validate.ValidateCodeRepository;
import com.wzero.security.validate.ValidateCodeType;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * @ClassName SessionValidateCodeRepository
 * @Description 会话 验证码 存储库
 * @Author WJJ
 * @Date 2020/08/03 10:15
 * @Version 1.0
 */
public class SessionValidateCodeRepository implements ValidateCodeRepository {
    String SESSION_KEY_PREFIX = "SESSION_KEY_FOR_CODE_";

    private String getSessionKey(ServletWebRequest webRequest,ValidateCodeType codeType) {
        return this.SESSION_KEY_PREFIX + codeType.toString().toUpperCase();
    }

    @Override
    public void save(ServletWebRequest webRequest, ValidateCode validateCode, ValidateCodeType codeType) {
        webRequest.getRequest().getSession().setAttribute(this.getSessionKey(webRequest,codeType),validateCode);
    }

    @Override
    public ValidateCode get(ServletWebRequest webRequest, ValidateCodeType codeType) {
        return (ValidateCode) webRequest.getRequest().getSession().getAttribute(this.getSessionKey(webRequest,codeType));
    }

    @Override
    public void remove(ServletWebRequest webRequest, ValidateCodeType codeType) {
        webRequest.getRequest().getSession().removeAttribute(this.getSessionKey(webRequest,codeType));
    }
}
