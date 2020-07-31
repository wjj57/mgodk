package com.wzero.security.validate;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * @ClassName ValidateCodeRepository
 * @Description 验证码 存储库
 * @Author WJJ
 * @Date 2020/7/31 16:26
 * @Version 1.0
 */
public interface ValidateCodeRepository {
    void save(ServletWebRequest webRequest, ValidateCode validateCode, ValidateCodeType codeType) throws Exception;

    ValidateCode get(ServletWebRequest webRequest, ValidateCodeType codeType) throws Exception;

    void remove(ServletWebRequest webRequest, ValidateCodeType codeType) throws Exception;
}
