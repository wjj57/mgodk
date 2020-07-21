package com.wzero.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 实现 UserDetailsService 类，@Component，进行账号验证
 */
@SpringBootApplication
public class SecurityApplication {
    private static Logger logger = LoggerFactory.getLogger(SecurityApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SecurityApplication.class,args);
        logger.info("SecurityApplication ===》 启动成功");
    }
}
