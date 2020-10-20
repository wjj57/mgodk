package com.mgodk.web.controller;

import com.mgodk.api.pojo.SysUser;
import com.mgodk.biz.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName SysUserController
 * @Description
 * @Author WJJ
 * @Date 2020/10/19 14:47
 * @Version 1.0
 */
@RestController
@RequestMapping("/sysUser")
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;

    @RequestMapping("/list")
    public List<SysUser> getList() throws Exception {
        return sysUserService.findList(null);
    }
}
