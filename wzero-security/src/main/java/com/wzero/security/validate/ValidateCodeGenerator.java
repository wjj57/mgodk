package com.wzero.security.validate;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * @ClassName ValidateCodeGenerator
 * @Description 验证码 生成器
 * @Author WJJ
 * @Date 2020/7/30 9:08
 * @Version 1.0
 */
public interface ValidateCodeGenerator {
    ValidateCode generate(ServletWebRequest webRequest);
}
