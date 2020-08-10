package com.wzero.security.validate;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * @ClassName ValidateCodeProcessor
 * @Description 验证码 处理器
 * @Author WJJ
 * @Date 2020/7/31 15:17
 * @Version 1.0
 */
public interface ValidateCodeProcessor {
    void create(ServletWebRequest webRequest) throws Exception;

    void validate(ServletWebRequest webRequest);
}
