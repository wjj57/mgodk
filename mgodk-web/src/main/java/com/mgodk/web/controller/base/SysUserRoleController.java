package com.mgodk.web.controller.base;

import com.mgodk.biz.service.SysUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName SysUserRoleController
 * @Description 用户角色关系 模块管理
 * @Author WJJ
 * @Date 2020/12/23 17:14
 * @Version 1.0
 */
@RestController
@RequestMapping("/sysUserRole")
public class SysUserRoleController {
    @Autowired
    private SysUserRoleService sysUserRoleService;
}
