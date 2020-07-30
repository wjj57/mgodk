package com.wzero.security.properties;

/**
 * @ClassName SmsCodeProperties
 * @Description 自定义 短信验证码 属性文件
 * @Author WJJ
 * @Date 2020/7/30 15:01
 * @Version 1.0
 */
public class SmsCodeProperties {
    /** 长度 */
    private int length = 6;
    /** 过期时间 */
    private int expireIn = 60;
    /** 路径 */
    private String url;

    public SmsCodeProperties() {}

    public int getLength() {
        return length;
    }
    public void setLength(int length) {
        this.length = length;
    }
    public int getExpireIn() {
        return expireIn;
    }
    public void setExpireIn(int expireIn) {
        this.expireIn = expireIn;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
}
