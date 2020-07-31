package com.wzero.security.validate.sms;

/**
 * @ClassName SmsCodeSender
 * @Description 发送 短信验证码
 * @Author WJJ
 * @Date 2020/7/31 15:48
 * @Version 1.0
 */
public interface SmsCodeSender {
    void send(String mobile, String code) throws Exception;
}
