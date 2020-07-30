package com.wzero.security.properties;

/**
 * @ClassName ValidateCodeProperties
 * @Description 自定义 验证码 属性文件
 * @Author WJJ
 * @Date 2020/7/30 14:59
 * @Version 1.0
 */
public class ValidateCodeProperties {
    private ImageCodeProperties image = new ImageCodeProperties();
    private SmsCodeProperties sms = new SmsCodeProperties();

    public ValidateCodeProperties() {}

    public ImageCodeProperties getImage() {
        return image;
    }
    public void setImage(ImageCodeProperties image) {
        this.image = image;
    }
    public SmsCodeProperties getSms() {
        return sms;
    }
    public void setSms(SmsCodeProperties sms) {
        this.sms = sms;
    }
}
