package com.wzero.security.validate;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * @ClassName ValidateCodeProcessorHolder
 * @Description 验证码 处理器 持有人
 * @Author WJJ
 * @Date 2020/08/03 17:49
 * @Version 1.0
 */
public class ValidateCodeProcessorHolder {
    @Autowired
    private Map<String,ValidateCodeProcessor> validateCodeProcessors;

//    public ValidateCodeProcessor findValidateCodeProcessor(ValidateCodeType codeType) {}
}
