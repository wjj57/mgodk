package com.mgodk.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Package com.mgodk.web
 * @ClassName MgodkWebApplication
 * @Description
 * @Author WJJ
 * @Date 2020/7/15 10:06
 * @Version 1.0
 */
@ComponentScan({"com.mgodk"})//扫描 加注解 @Component 的组件
//@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)//
//@EnableTransactionManagement//开启 事务管理
//@EnableScheduling//开启 定时任务
@SpringBootApplication
public class MgodkWebApplication {
    private static Logger logger = LoggerFactory.getLogger(MgodkWebApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(MgodkWebApplication.class,args);
        logger.info("MgodkWebApplication ===》 启动成功");
    }
}
