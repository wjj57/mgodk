package com.mgodk.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName ViewController
 * @Description
 * @Author WJJ
 * @Date 2020/12/08 10:45
 * @Version 1.0
 */
@Controller
@RequestMapping("/page")
public class ViewController {
    @GetMapping("/login")
    public String toPageLogin() {
        return "login";
    }

    @GetMapping("/register")
    public String toPageRegister() {
        return "register";
    }

    @GetMapping("/index")
    public String toPageIndex() {
        return "index";
    }

    @GetMapping("/sysUser")
    public String toPageSysUser() {
        return "sys_user/sys_user_list";
    }
}
