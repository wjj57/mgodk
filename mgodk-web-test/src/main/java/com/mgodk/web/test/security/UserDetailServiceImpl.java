package com.mgodk.web.test.security;

import com.wzero.security.model.pojo.SecurityUserDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
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
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("用户名：" + username);

        SecurityUserDetails userDetails = new SecurityUserDetails();
        userDetails.setUserId(1);
        userDetails.setUsername("admin");
        userDetails.setPassword(passwordEncoder.encode("123456"));
        userDetails.setEnabled(true);
        userDetails.setAccountNonExpired(true);
        userDetails.setCredentialsNonExpired(true);
        userDetails.setAccountNonLocked(true);
        return userDetails;
    }
}
