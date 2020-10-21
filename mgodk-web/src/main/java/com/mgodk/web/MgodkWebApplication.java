package com.mgodk.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Package com.mgodk.web
 * @ClassName MgodkWebApplication
 * @Description 启动类
 * @Author WJJ
 * @Date 2020/7/15 10:06
 * @Version 1.0
 */
@EnableTransactionManagement //开启 事务管理
@MapperScan("com.mgodk.biz.mapper") //扫描 mapper 接口，生成实现类及注入容器中（在非主程序下的包不能使用 @Mapper）
@ComponentScan({"com.mgodk.biz","com.mgodk.web"}) //扫描 @Repository @Service @Controller @Component 等组件到容器中
@SpringBootApplication
public class MgodkWebApplication {
    private static Logger logger = LoggerFactory.getLogger(MgodkWebApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(MgodkWebApplication.class,args);
        logger.info("MgodkWebApplication ===》 启动成功");
    }
}