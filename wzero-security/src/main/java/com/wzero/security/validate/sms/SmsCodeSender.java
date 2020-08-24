package com.wzero.security.validate.sms;

/**
 * @ClassName SmsCodeSender
 * @Description 发送 短信验证码
 * @Version 1.0
 */
public interface SmsCodeSender {
    void send(String mobile, String code) throws Exception;
}
