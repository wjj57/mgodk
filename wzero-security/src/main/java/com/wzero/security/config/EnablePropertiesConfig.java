package com.wzero.security.config;

import com.wzero.security.properties.SecurityProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName EnablePropertiesConfig
 * @Description 配置 启用设置
 * @Version 1.0
 */
@Configuration
@EnableConfigurationProperties({SecurityProperties.class})
public class EnablePropertiesConfig {
    public EnablePropertiesConfig() {}
}
