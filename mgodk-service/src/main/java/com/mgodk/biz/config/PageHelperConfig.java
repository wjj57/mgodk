package com.mgodk.biz.config;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.plugin.Interceptor;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * @ClassName PageHelperConfig
 * @Description 分页插件 配置类
 * @Author WJJ
 * @Date 2020/09/07 14:50
 * @Version 1.0
 */
@Configuration
public class PageHelperConfig {
    /**配置 分页插件
     * @return
     */
    @Bean
    public PageHelper pageHelper(){
        PageHelper pageHelper=new PageHelper();
        Properties properties=new Properties();
        properties.setProperty("helperDialect","mysql");
        properties.setProperty("reasonable","true");
        properties.setProperty("supportMethodsArguments","true");
        properties.setProperty("params","count=countSql");
        pageHelper.setProperties(properties);
        Interceptor interceptor = new PageInterceptor();
        interceptor.setProperties(properties);
        new SqlSessionFactoryBean().setPlugins(new Interceptor[]{interceptor});
        return pageHelper;
    }
}
