package com.mgodk.biz.service.impl;

import com.mgodk.biz.mapper.SysRoleMapper;
import com.mgodk.biz.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName SysRoleServiceImpl
 * @Description 业务逻辑之 系统角色模块实现
 * @Author WJJ
 * @Date 2020/10/19 11:37
 * @Version 1.0
 */
@Service
public class SysRoleServiceImpl implements SysRoleService {
    @Autowired
    private SysRoleMapper sysRoleMapper;
}
