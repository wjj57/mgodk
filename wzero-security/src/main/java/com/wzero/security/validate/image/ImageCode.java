package com.wzero.security.validate.image;

import com.wzero.security.validate.ValidateCode;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

/**
 * @ClassName ImageCode
 * @Description 图片验证码 数据类型
 * @Author WJJ
 * @Date 2020/7/29 17:39
 * @Version 1.0
 */
public class ImageCode extends ValidateCode {
    private static final long serialVersionUID = -75809535L;
    private BufferedImage image;

    public ImageCode(String code, int expireIn, BufferedImage image) {
        super(code, expireIn);
        this.image = image;
    }

    public ImageCode(String code, LocalDateTime expireTime, BufferedImage image) {
        super(code, expireTime);
        this.image = image;
    }

    public BufferedImage getImage() {
        return image;
    }
    public void setImage(BufferedImage image) {
        this.image = image;
    }
}
