package com.maven.web.controller;

import com.maven.web.entity.pojo.SysUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName ViewController
 * @Description 前后端分离，返回页面
 * @Author WJJ
 * @Date 2020/11/10 17:22
 * @Version 1.0
 */
@Controller
@RequestMapping("/view")
public class ViewController {
    @RequestMapping(value = "/index")
    public String toPageIndex() throws Exception {
        return "index";
    }

    @RequestMapping(value = "/list")
    @ResponseBody
    public SysUser list() throws Exception {
        SysUser sysUser = new SysUser();
        sysUser.setUserId(12);
        sysUser.setLoginName("user-admin");
        sysUser.setUserName("阿萨的");
        return sysUser;
    }
}
