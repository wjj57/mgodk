package com.mgodk.web.core.config;

import com.mgodk.web.core.security.BCryptPasswordEncoder;
import com.mgodk.web.core.security.PasswordEncoder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName BeanConfig
 * @Description 配置 Bean 组件
 * @Author WJJ
 * @Date 2020/12/10 17:13
 * @Version 1.0
 */
@Configuration
public class BeanConfig {
    /** 配置 密码加密方式 */
    @Bean
    @ConditionalOnMissingBean({PasswordEncoder.class})
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
