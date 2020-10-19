package com.mgodk.web.test;

import org.apache.ibatis.annotations.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import tk.mybatis.spring.annotation.MapperScan;

//@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)//
//@EnableTransactionManagement//开启 事务管理
//@EnableScheduling//开启 定时任务
//@EnableJms//开启 扫描触发使用@JmsListener注解的方法，创建消息监听器容器
//@ComponentScan({"com"})//扫描 加注解 @Component 的组件
@SpringBootApplication
@ComponentScan({"com.mgodk.biz","com.mgodk.web"})
@MapperScan("com.mgodk.biz.mapper")
public class MgodkWebTsetApplication {
    private static Logger logger = LoggerFactory.getLogger(MgodkWebTsetApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(MgodkWebTsetApplication.class,args);
        logger.info("Mgodk Web Tset Application ===》 启动成功");
    }
}
