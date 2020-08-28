package com.wzero.security.properties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @ClassName SmsCodeProperties
 * @Description 自定义 短信验证码 属性文件
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SmsCodeProperties {
    /** 长度 */
    private int length = 4;
    /** 过期时间 */
    private int expireIn = 60;
    /** 路径 */
    private String url;

}
