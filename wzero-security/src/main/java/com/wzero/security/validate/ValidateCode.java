package com.wzero.security.validate;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @ClassName ValidateCode
 * @Description 验证码 数据类型
 * @Author WJJ
 * @Date 2020/7/29 16:30
 * @Version 1.0
 */
public class ValidateCode implements Serializable {
    private static final long serialVersionUID = -94L;
    private String code;
    private LocalDateTime expireTime;

    public boolean isExpried() {
        return LocalDateTime.now().isAfter(this.expireTime);
    }

    public ValidateCode(String code, int expireIn) {
        this.code = code;
        this.expireTime = LocalDateTime.now().plusSeconds((long)expireIn);
    }

    public ValidateCode(String code, LocalDateTime expireTime) {
        this.code = code;
        this.expireTime = expireTime;
    }

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public LocalDateTime getExpireTime() {
        return expireTime;
    }
    public void setExpireTime(LocalDateTime expireTime) {
        this.expireTime = expireTime;
    }
}
