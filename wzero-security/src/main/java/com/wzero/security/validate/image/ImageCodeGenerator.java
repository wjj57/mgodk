package com.wzero.security.validate.image;

import com.wzero.security.properties.SecurityProperties;
import com.wzero.security.util.ImageCodeUtil;
import com.wzero.security.validate.ValidateCode;
import com.wzero.security.validate.ValidateCodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;

import java.awt.*;

/**
 * @ClassName ImageCodeGenerator
 * @Description 图片验证码 生成器
 * @Version 1.0
 */
public class ImageCodeGenerator implements ValidateCodeGenerator {
    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public ValidateCode generate(ServletWebRequest webRequest) throws Exception {
        int width = ServletRequestUtils.getIntParameter(webRequest.getRequest(),"width",
                this.securityProperties.getValidateCode().getImage().getWidth());
        int height = ServletRequestUtils.getIntParameter(webRequest.getRequest(),"height",
                this.securityProperties.getValidateCode().getImage().getHeight());
        int length = ServletRequestUtils.getIntParameter(webRequest.getRequest(),"length",
                this.securityProperties.getValidateCode().getImage().getLength());
        //生成 图片验证码
        ImageCode imageCode = ImageCodeUtil.getRandomImage(width,height,length,new Font("Times New Roman", 1, 20));
        imageCode.setExpireInToTime(this.securityProperties.getValidateCode().getImage().getExpireIn());
        return imageCode;
    }
}
