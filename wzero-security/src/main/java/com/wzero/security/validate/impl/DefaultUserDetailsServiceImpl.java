package com.wzero.security.validate.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @ClassName DefaultUserDetailsServiceImpl
 * @Description 自定义 默认用户登录验证处理逻辑
 * @Version 1.0
 */
@Service
public class DefaultUserDetailsServiceImpl implements UserDetailsService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("请配置 UserDetailsService 接口的实现");
        throw new UsernameNotFoundException(username);
    }
}
