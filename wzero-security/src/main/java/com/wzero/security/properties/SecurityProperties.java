package com.wzero.security.properties;

import com.wzero.security.model.CommonConstants;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @ClassName SecurityProperties
 * @Description 自定义 属性文件
 * @Author WJJ
 * @Date 2020/7/30 9:03
 * @Version 1.0
 * 注：使用@ConfigurationProperties 后，要加@Component 或使用@EnableConfigurationProperties,
 *      此处在 EnablePropertiesConfig 中添加
 */
@ConfigurationProperties(prefix = "wzero.security")
public class SecurityProperties {
    private BrowserProperties browser = new BrowserProperties();
    private ValidateCodeProperties validateCode = new ValidateCodeProperties();

    public SecurityProperties() {}

    public BrowserProperties getBrowser() {
        return browser;
    }
    public void setBrowser(BrowserProperties browser) {
        this.browser = browser;
    }
    public ValidateCodeProperties getValidateCode() {
        return validateCode;
    }
    public void setValidateCode(ValidateCodeProperties validateCode) {
        this.validateCode = validateCode;
    }
}
