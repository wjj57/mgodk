package com.wzero.security.validate.impl;

import com.wzero.security.model.pojo.SecurityUserDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @ClassName DefaultUserDetailsServiceImpl
 * @Description 自定义 默认用户登录验证处理逻辑
 * @Version 1.0
 */
public class DefaultUserDetailsServiceImpl implements UserDetailsService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        this.logger.warn("*请配置 UserDetailsService 接口的实现");
        this.logger.info("当前登录验证账号为：" + username);

        return fandByUserName(username);
    }

    /** 默认测试数据 */
    private UserDetails fandByUserName(String username) throws UsernameNotFoundException {
        Map<String,UserDetails> map = new HashMap<>();
        SecurityUserDetails admin = new SecurityUserDetails();
        SecurityUserDetails user = new SecurityUserDetails();
        SecurityUserDetails padmin = new SecurityUserDetails();
        SecurityUserDetails puser = new SecurityUserDetails();
        //初始化数据 权限
        List<GrantedAuthority> adminAutho = new ArrayList<>();
        adminAutho.add(new SimpleGrantedAuthority("admin"));
        adminAutho.add(new SimpleGrantedAuthority("user"));
        adminAutho.add(new SimpleGrantedAuthority("visitor"));
        List<GrantedAuthority> userAutho = new ArrayList<>();
        userAutho.add(new SimpleGrantedAuthority("user"));
        //初始化数据 管理员
        admin.setUserId(1);
        admin.setUsername("admin");
        admin.setPassword(this.passwordEncoder.encode("admin"));
        admin.setAuthorities(adminAutho);
        admin.setEnabled(true);
        admin.setAccountNonExpired(true);
        admin.setCredentialsNonExpired(true);
        admin.setAccountNonLocked(true);
        padmin.setUserId(2);
        padmin.setUsername("111111");
        padmin.setPassword(this.passwordEncoder.encode("111111"));
        padmin.setAuthorities(adminAutho);
        padmin.setEnabled(true);
        padmin.setAccountNonExpired(true);
        padmin.setCredentialsNonExpired(true);
        padmin.setAccountNonLocked(true);
        //初始化数据 用户
        user.setUserId(6);
        user.setUsername("user");
        user.setPassword(this.passwordEncoder.encode("user"));
        user.setAuthorities(userAutho);
        user.setEnabled(true);
        user.setAccountNonExpired(true);
        user.setCredentialsNonExpired(true);
        user.setAccountNonLocked(true);
        puser.setUserId(7);
        puser.setUsername("123456");
        puser.setPassword(this.passwordEncoder.encode("123456"));
        puser.setAuthorities(userAutho);
        puser.setEnabled(true);
        puser.setAccountNonExpired(true);
        puser.setCredentialsNonExpired(true);
        puser.setAccountNonLocked(true);
        //初始化数据
        map.put("admin",admin);
        map.put("user",user);
        map.put("111111",padmin);
        map.put("123456",puser);
        //验证
        UserDetails userDetails = map.get(username);
        if (Objects.isNull(userDetails)) {
            throw new UsernameNotFoundException("账号不存在");
        }
        return userDetails;
    }
}
