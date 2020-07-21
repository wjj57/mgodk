package com.wzero.security.pojo;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @ClassName SecurityUserDetails
 * @Description Security 登录用户信息
 * @Author WJJ
 * @Date 2020/7/21 17:05
 * @Version 1.0
 */
@Data
public class SecurityUserDetails implements UserDetails {
    private Integer userId;
    /**用户名*/
    private String username;
    /**密码*/
    private String password;
    /**授予的权限*/
    private List<GrantedAuthority> authorities;
    /**指示用户是启用还是禁用*/
    private boolean isEnabled;
    /**指示用户的帐户是否已过期*/
    private boolean isAccountNonExpired;
    /**指示用户是锁定还是解锁,比如 登录错误 4次后进行账户锁定*/
    private boolean isAccountNonLocked;
    /**指示用户的凭据（密码）是否已过期*/
    private boolean isCredentialsNonExpired;

    /**用户拥有的角色Role*/
    private List<String> roles = new ArrayList<>();
    /**用户有权访问的url*/
    private List<String> urls = new ArrayList<>();
}
