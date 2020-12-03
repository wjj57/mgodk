package com.mgodk.web.controller;

import com.mgodk.api.pojo.SysUser;
import com.mgodk.biz.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * @ClassName SysUserController
 * @Description
 * @Author WJJ
 * @Date 2020/10/19 14:47
 * @Version 1.0
 */
@RestController
@RequestMapping("/sysUser")
@Slf4j
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;

    @RequestMapping(value = "/list")
    public List<SysUser> getList() throws Exception {
        log.debug("Controller层 》 debug");
        log.info("Controller层 》 info");
        log.warn("Controller层 》 warn");
        log.error("Controller层 》 error");
        return sysUserService.findList(null);
    }
}
