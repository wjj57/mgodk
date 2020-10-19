package com.mgodk.biz.service.impl;

import com.mgodk.biz.mapper.SysUserRoleMapper;
import com.mgodk.biz.service.SysUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName SysUserRoleServiceImpl
 * @Description 业务逻辑之 系统用户角色关系模块实现
 * @Author WJJ
 * @Date 2020/10/19 11:40
 * @Version 1.0
 */
@Service
public class SysUserRoleServiceImpl implements SysUserRoleService {
    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;
}
