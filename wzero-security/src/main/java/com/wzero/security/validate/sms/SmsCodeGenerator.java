package com.wzero.security.validate.sms;

import com.wzero.security.properties.SecurityProperties;
import com.wzero.security.validate.ValidateCode;
import com.wzero.security.validate.ValidateCodeGenerator;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * @ClassName SmsCodeGenerator
 * @Description 短信 验证码 生成器
 * @Version 1.0
 */
public class SmsCodeGenerator implements ValidateCodeGenerator {
    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public ValidateCode generate(ServletWebRequest webRequest) throws Exception {
        String code = RandomStringUtils.randomNumeric(this.securityProperties.getValidateCode().getSms().getLength());
        return new ValidateCode(code,this.securityProperties.getValidateCode().getSms().getExpireIn());
    }
}
