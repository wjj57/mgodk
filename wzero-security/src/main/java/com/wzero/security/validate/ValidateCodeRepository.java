package com.wzero.security.validate;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * @ClassName ValidateCodeRepository
 * @Description 验证码 存储库
 * @Version 1.0
 */
public interface ValidateCodeRepository {
    void save(ServletWebRequest webRequest, ValidateCode validateCode, ValidateCodeType codeType);

    ValidateCode get(ServletWebRequest webRequest, ValidateCodeType codeType);

    void remove(ServletWebRequest webRequest, ValidateCodeType codeType);
}
