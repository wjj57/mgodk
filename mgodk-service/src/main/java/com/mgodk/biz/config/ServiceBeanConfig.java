package com.mgodk.biz.config;

import com.mgodk.biz.util.SnowflakeIdWorker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName ServiceBeanConfig
 * @Description 配置 Bean 组件
 * @Author WJJ
 * @Date 2020/12/21 16:49
 * @Version 1.0
 */
@Configuration
public class ServiceBeanConfig {
    /** 配置 ID 生成方式 */
    @Bean
    public SnowflakeIdWorker snowflakeIdWorker() {
        return new SnowflakeIdWorker();
    }
}
