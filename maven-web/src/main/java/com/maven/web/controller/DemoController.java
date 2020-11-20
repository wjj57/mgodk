package com.maven.web.controller;

import com.maven.web.entity.pojo.SysUser;
import com.maven.web.service.SysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
    private static final Logger logger = LoggerFactory.getLogger(DemoController.class);

    @Autowired
    private SysUserService sysUserService;

    @RequestMapping(value = "/li")
    public SysUser getOne() throws Exception {
        SysUser sysUser = new SysUser();
        sysUser.setUserId(12);
        sysUser.setLoginName("user-admin");
        sysUser.setUserName("阿萨的");
        return sysUser;
    }

    @RequestMapping(value = "/list")
    public List<SysUser> list() throws Exception {
        logger.debug("DemoController_debug");
        logger.info("DemoController_info");
        logger.warn("DemoController_warn");
        logger.error("DemoController_error");
        return sysUserService.findList(null);
    }

}
