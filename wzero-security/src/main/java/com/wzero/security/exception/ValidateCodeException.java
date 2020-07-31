package com.wzero.security.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * @ClassName ValidateCodeException
 * @Description 验证码 错误
 * @Author WJJ
 * @Date 2020/7/31 17:12
 * @Version 1.0
 */
public class ValidateCodeException extends AuthenticationException {
    private static final long serialVersionUID = -112L;

    public ValidateCodeException(String msg) {
        super(msg);
    }
}
