package com.wzero.security.validate.sms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName DefaultSmsCodeSender
 * @Description 默认发送 短信验证码
 * @Author WJJ
 * @Date 2020/7/31 15:53
 * @Version 1.0
 */
public class DefaultSmsCodeSender implements SmsCodeSender {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void send(String mobile, String code) throws Exception {
        this.logger.warn("请配置真实的短信验证码发送器 (SmsCodeSender)");
        this.logger.info("向手机" + mobile + "发送短信验证码" + code);
    }
}
