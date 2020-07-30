package com.wzero.security.properties;

/**
 * @ClassName ImageCodeProperties
 * @Description 自定义 图片验证码 属性文件
 * @Author WJJ
 * @Date 2020/7/30 15:06
 * @Version 1.0
 */
public class ImageCodeProperties {
    /** 宽度 */
    private int width = 67;
    /** 长度 */
    private int height = 23;
    /**  */
    private int flag = 0;

    public ImageCodeProperties() {}

    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public int getFlag() {
        return flag;
    }
    public void setFlag(int flag) {
        this.flag = flag;
    }
}
