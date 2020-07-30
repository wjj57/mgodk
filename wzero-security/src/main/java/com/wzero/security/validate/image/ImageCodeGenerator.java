package com.wzero.security.validate.image;

import com.wzero.security.properties.SecurityProperties;
import com.wzero.security.validate.ValidateCode;
import com.wzero.security.validate.ValidateCodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * @ClassName ImageCodeGenerator
 * @Description 图片验证码 生成器
 * @Author WJJ
 * @Date 2020/7/30 9:18
 * @Version 1.0
 */
public class ImageCodeGenerator implements ValidateCodeGenerator {
    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public ValidateCode generate(ServletWebRequest webRequest) {
        return null;
    }
}
