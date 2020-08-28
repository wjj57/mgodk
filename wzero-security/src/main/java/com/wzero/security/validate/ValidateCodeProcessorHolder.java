package com.wzero.security.validate;

import com.wzero.security.exception.ValidateCodeException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * @ClassName ValidateCodeProcessorHolder
 * @Description 验证码 处理器 持有人
 * @Version 1.0
 */
public class ValidateCodeProcessorHolder {
    @Autowired
    private Map<String,ValidateCodeProcessor> validateCodeProcessors;

    public ValidateCodeProcessorHolder() {}

    public ValidateCodeProcessor findValidateCodeProcessor(ValidateCodeType codeType) {
        return this.findValidateCodeProcessor(codeType.toString().toLowerCase());
    }

    public ValidateCodeProcessor findValidateCodeProcessor(String type) {
        String name = type.toLowerCase() + ValidateCodeProcessor.class.getSimpleName();
        ValidateCodeProcessor processor = this.validateCodeProcessors.get(name);
        if (processor == null) {
            throw new ValidateCodeException("验证码处理器 " + name + " 不存在");
        } else {
            return processor;
        }
    }
}
