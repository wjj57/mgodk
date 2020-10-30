package com.maven.web.service.impl;

import com.maven.web.mapper.SysRoleMenuMapper;
import com.maven.web.service.SysRoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName SysRoleMenuServiceImpl
 * @Description 业务逻辑之 系统角色菜单关系模块实现
 * @Author WJJ
 * @Date 2020/10/19 11:39
 * @Version 1.0
 */
@Service
public class SysRoleMenuServiceImpl implements SysRoleMenuService {
    @Autowired
    private SysRoleMenuMapper sysRoleMenuMapper;
}
