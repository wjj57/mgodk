package com.mgodk.biz.service;

import com.mgodk.api.common.DataGridResult;
import com.mgodk.api.pojo.SysRole;

import java.util.List;

/**
 * @ClassName SysRoleService
 * @Description 业务逻辑之 系统角色模块
 * @Author WJJ
 * @Date 2020/10/19 11:37
 * @Version 1.0
 */
public interface SysRoleService {
    int saveSysRole(SysRole sysRole) throws Exception;

    int modifySysRoleById(SysRole sysRole) throws Exception;

    int removeSysRoleById(Long id) throws Exception;

    List<SysRole> findSysRoleList(SysRole sysRole) throws Exception;

    DataGridResult<SysRole> findSysRoleListPage(SysRole sysRole) throws Exception;

    SysRole findSysRoleByPower(String power) throws Exception;
}
