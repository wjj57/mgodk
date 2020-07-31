package com.wzero.security.validate.sms;

import com.wzero.security.model.CommonConstants;
import com.wzero.security.validate.ValidateCode;
import com.wzero.security.validate.impl.AbstractValidateCodeProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * @ClassName SmsCodeProcessor
 * @Description 短信验证码 处理器
 * @Author WJJ
 * @Date 2020/7/31 15:37
 * @Version 1.0
 */
public class SmsCodeProcessor extends AbstractValidateCodeProcessor<ValidateCode> {
    @Autowired
    private SmsCodeSender smsCodeSender;

    @Override
    protected void send(ServletWebRequest webRequest, ValidateCode validateCode) throws Exception {
        String mobile = ServletRequestUtils.getRequiredStringParameter(webRequest.getRequest(),
                CommonConstants.DEFAULT_PARAMETER_NAME_MOBILE);
        this.smsCodeSender.send(mobile,validateCode.getCode());
    }
}
