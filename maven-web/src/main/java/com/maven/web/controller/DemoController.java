package com.maven.web.controller;

import com.maven.web.service.SysUserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName DemoController
 * @Description
 * @Author WJJ
 * @Date 2020/10/30 11:40
 * @Version 1.0
 */
@RestController
//@Controller
@RequestMapping(value = "/demo")
public class DemoController {

    @Autowired
    private SysUserService sysUserService;

    @RequestMapping(value = "/l")
    public String index() throws Exception {
        return "index";
    }

    @RequestMapping(value = "/list")
    public String list() throws Exception {
        Log log = LogFactory.getLog(DemoController.class);
        log.info("黑暗时代和阿斯顿");
        return sysUserService.findList(null).toString();
    }

}
