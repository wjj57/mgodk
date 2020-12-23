package com.mgodk.web.controller.base;

import com.mgodk.biz.service.SysRoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName SysRoleMenuController
 * @Description 角色菜单关系 模块管理
 * @Author WJJ
 * @Date 2020/12/23 17:14
 * @Version 1.0
 */
@RestController
@RequestMapping("/sysRoleMenu")
public class SysRoleMenuController {
    @Autowired
    private SysRoleMenuService sysRoleMenuService;
}
