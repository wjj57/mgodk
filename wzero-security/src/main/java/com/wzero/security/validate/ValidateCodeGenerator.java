package com.wzero.security.validate;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * @ClassName ValidateCodeGenerator
 * @Description 验证码 生成器
 * @Version 1.0
 */
public interface ValidateCodeGenerator {
    ValidateCode generate(ServletWebRequest webRequest) throws Exception;
}
