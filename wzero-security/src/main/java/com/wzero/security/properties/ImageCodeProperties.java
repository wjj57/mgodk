package com.wzero.security.properties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @ClassName ImageCodeProperties
 * @Description 自定义 图片验证码 属性文件
 * @Version 1.0
 */
@Data
//@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ImageCodeProperties extends SmsCodeProperties{
    /** 宽度 */
    private int width = 67;
    /** 长度 */
    private int height = 23;
    /**  */
    private int flag = 0;

    public ImageCodeProperties() {
        //this.setLength(4);
    }

}
