package com.mgodk.biz.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * @ClassName MybatisConfig
 * @Description Mybatis 配置
 * @Author WJJ
 * @Date 2020/10/20 10:02
 * @Version 1.0
 */
//@Configuration
public abstract class MybatisConfig {
    @Autowired
    private DataSource dataSource;

    /** 配置 Mybatis全局参数，并添加到容器中 */
//    @Bean
    public ConfigurationCustomizer configurationCustomizer() {
        return new ConfigurationCustomizer() {
            @Override
            public void customize(org.apache.ibatis.session.Configuration configuration) {
                //设置 开启驼峰命名法
                //configuration.setMapUnderscoreToCamelCase(true);
                //设置 日志工具
                //configuration.setLogImpl(Log4jImpl.class);
            }
        };
    }

    /** 配置 Mybatis的 Sql会话工厂：需要设置数据源 */
//    @Bean
    public SqlSessionFactoryBean sqlSessionFactory() throws IOException {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        //设置数据源
        sessionFactory.setDataSource(dataSource);
        //设置扫描实体类包，起别名
        sessionFactory.setTypeAliasesPackage("com.mgodk.api.pojo");
        //设置Mybatis接口的xml映射文件，指定的文件夹必须存在
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sessionFactory.setMapperLocations(resolver.getResources("classpath:/mapper/*Mapper.xml"));
        return sessionFactory;
    }
}
