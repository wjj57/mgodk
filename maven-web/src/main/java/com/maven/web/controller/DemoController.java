package com.maven.web.controller;

import com.maven.web.entity.pojo.SysUser;
import com.maven.web.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName DemoController
 * @Description
 * @Author WJJ
 * @Date 2020/10/30 11:40
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/demo")
public class DemoController {
    @Autowired
    private SysUserService sysUserService;

    @RequestMapping(value = "/l")
    public String index() throws Exception {
        return "index";
    }

    @RequestMapping(value = "/list")
    public List<SysUser> lidt() throws Exception {
        return sysUserService.findList(null);
    }
}
