package com.wzero.security.validate.image;

import com.wzero.security.model.CommonConstants;
import com.wzero.security.validate.impl.AbstractValidateCodeProcessor;
import org.springframework.web.context.request.ServletWebRequest;

import javax.imageio.ImageIO;

/**
 * @ClassName ImageCodeProcessor
 * @Description 图片验证码 处理器
 * @Version 1.0
 */
public class ImageCodeProcessor extends AbstractValidateCodeProcessor<ImageCode> {
    public ImageCodeProcessor() {}

    @Override
    protected void send(ServletWebRequest webRequest, ImageCode imageCode) throws Exception {
        ImageIO.write(imageCode.getImage(), CommonConstants.IMAGE_FORMAT_NAME_JPEG,webRequest.getResponse().getOutputStream());
    }
}
