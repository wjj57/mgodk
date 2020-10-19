package com.mgodk.biz.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName DruidConfig
 * @Description Druid数据库连接池及 Mysql数据源 配置类
 * @Author WJJ
 * @Date 2020/09/07 15:00
 * @Version 1.0
 */
//@Configuration
public class DruidConfig {
    /**配置 数据库连接、数据源信息，将数据源注册到容器中
     * @return
     * 注：@ConfigurationProperties 是参照默认配置写的，可以省略，其默认为spring.datasource，
     * 也可以修改默认，在其后面加自定义数据源名称 spring.datasource.druid ；
     */
//    @ConfigurationProperties(prefix = "spring.datasource.druid")
//    @Bean(initMethod = "init",destroyMethod = "close")
//    @Transient
    public DruidDataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        //dataSource.setDbType("com.alibaba.druid.pool.DruidDataSource");
        //dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        //dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/myserver?serverTimezone=GMT%2B8&useSSL=false&useUnicode=true&characterEncoding=utf-8");
        //dataSource.setUsername("root");
        //dataSource.setPassword("tiger");
        //dataSource.setTestOnBorrow(true);
        //dataSource.setTestWhileIdle(true);

        //import com.google.config.collect.Lists;
//        dataSource.setProxyFilters(Lists.newArrayList(stateFilter()));
        return dataSource;
    }
    /*@Bean//import javax.servlet.servlet-api;
    public Filter stateFilter(){
        StatFilter filter = new StatFilter();
        filter.setSlowSqlMillis(1);
        filter.setLogSlowSql(false);
        filter.setMergeSql(false);
        return filter;
    }*/

    /**配置 事务管理，开启事务@EnableTransactionManagement；手动事物管理，当方法使用内部方法时，注解无效
     * @return
     */
//    @Bean
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

    /**配置 Druid监控，一个管理后台的Servlet控制
     * @return statViewServlet
     * @throws Exception
     */
//    @Bean
    public ServletRegistrationBean statViewServlet() throws Exception {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new StatViewServlet(),
                "/druid/*");
        Map<String,String> initParams = new HashMap<>();
        initParams.put("loginUsername","admin");
        initParams.put("loginPassword","123456");
        //默认就是允许所有访问
        initParams.put("allow","");
        //禁止以ip地址访问后台管理；以ip地址访问返回：Sorry,you are not permitted to view this page.
        initParams.put("deny","192.168.15.21");
        registrationBean.setInitParameters(initParams);
        return registrationBean;
    }

    /**配置 一个web监控的filter
     * @return webStatFilter
     * @throws Exception
     */
//    @Bean
    public FilterRegistrationBean webStatFilter() throws Exception {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new WebStatFilter());
        Map<String,String> initParams = new HashMap<>();
        initParams.put("exclusions","*.js,*.css,/druid/*");
        registrationBean.setInitParameters(initParams);
        registrationBean.setUrlPatterns(Arrays.asList("/*"));
        return registrationBean;
    }
}
