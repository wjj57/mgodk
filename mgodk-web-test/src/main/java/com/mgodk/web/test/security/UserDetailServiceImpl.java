package com.mgodk.web.test.security;

import com.wzero.security.model.pojo.SecurityUserDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * @ClassName UserDetailServiceImpl
 * @Description
 * @Author WJJ
 * @Date 2020/08/24 10:42
 * @Version 1.0
 */
@Slf4j
@Component
@Primary
public class UserDetailServiceImpl implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        log.info("用户名"+s);
        SecurityUserDetails userDetails = new SecurityUserDetails();
        userDetails.setUserId(1);
        userDetails.setUsername("admin");
        userDetails.setPassword("123456");
        userDetails.setEnabled(true);
        userDetails.setAccountNonExpired(true);
        userDetails.setCredentialsNonExpired(true);
        userDetails.setAccountNonLocked(true);
        return userDetails;
    }
}
