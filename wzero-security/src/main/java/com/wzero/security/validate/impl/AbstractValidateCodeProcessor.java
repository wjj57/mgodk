package com.wzero.security.validate.impl;

import com.wzero.security.exception.ValidateCodeException;
import com.wzero.security.model.CommonConstants;
import com.wzero.security.validate.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;

import java.util.Map;

/**
 * @ClassName AbstractValidateCodeProcessor
 * @Description 验证码 处理器 抽象类处理
 * @Author WJJ
 * @Date 2020/7/31 15:23
 * @Version 1.0
 */
public abstract class AbstractValidateCodeProcessor<T extends ValidateCode> implements ValidateCodeProcessor {
    @Autowired
    private Map<String, ValidateCodeGenerator> validateCodeGenerators;
    @Autowired
    private ValidateCodeRepository validateCodeRepository;

    @Override
    public void create(ServletWebRequest webRequest) throws Exception {
        T validateCode = this.generate(webRequest);
        this.save(webRequest,validateCode);
        this.send(webRequest,validateCode);
    }

    @Override
    public void validate(ServletWebRequest webRequest) throws Exception {
        ValidateCodeType codeType = this.getValidateCodeType(webRequest);
        ValidateCode codeInSession = this.validateCodeRepository.get(webRequest, codeType);
        String codeInRequest;
        try {
            codeInRequest = ServletRequestUtils.getStringParameter(webRequest.getRequest(), codeType.getValidateCodeTypeName());
        } catch (ServletRequestBindingException var6) {
            throw new ValidateCodeException("获取验证码的值失败");
        }
        if (StringUtils.isBlank(codeInRequest)) {
            throw new ValidateCodeException(codeType + "验证码的值不能为空");
        } else if (codeInSession == null) {
            throw new ValidateCodeException(codeType + "验证码不存在");
        } else if (codeInSession.isExpried()) {
            this.validateCodeRepository.remove(webRequest, codeType);
            throw new ValidateCodeException(codeType + "验证码已过期");
        } else if (!StringUtils.equals(codeInSession.getCode(), codeInRequest)) {
            throw new ValidateCodeException(codeType + "验证码不匹配");
        } else {
            this.validateCodeRepository.remove(webRequest, codeType);
        }
    }

    protected abstract void send(ServletWebRequest webRequest, T t) throws Exception;

    private T generate(ServletWebRequest webRequest) throws Exception {
        String type = this.getValidateCodeType(webRequest).toString().toLowerCase();
        String generatorName = type + ValidateCodeGenerator.class.getSimpleName();
        ValidateCodeGenerator validateCodeGenerator = (ValidateCodeGenerator)this.validateCodeGenerators.get(generatorName);
        if (validateCodeGenerator == null) {
            throw new ValidateCodeException("验证码生成器" + generatorName + "不存在");
        }
        return (T)validateCodeGenerator.generate(webRequest);
    }

    private void save(ServletWebRequest webRequest, T validateCode) throws Exception {
        ValidateCode code = new ValidateCode(validateCode.getCode(), validateCode.getExpireTime());
        this.validateCodeRepository.save(webRequest, code, this.getValidateCodeType(webRequest));
    }

    private ValidateCodeType getValidateCodeType(ServletWebRequest webRequest) {
        return ValidateCodeType.valueOf(StringUtils.substringBefore(this.getClass().getSimpleName(),
                CommonConstants.DEFAULT_PARAMETER_NAME_SEPARATOR).toUpperCase());
    }
}
