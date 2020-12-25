package com.mgodk.biz.service;

import com.mgodk.api.common.DataGridResult;
import com.mgodk.api.pojo.SysUser;

import java.util.List;

/**
 * @ClassName SysUserService
 * @Description 业务逻辑之 系统用户模块
 * @Author WJJ
 * @Date 2020/10/16 11:22
 * @Version 1.0
 */
public interface SysUserService {
    int saveSysUser(SysUser sysUser) throws Exception;

    int modifySysUserById(SysUser sysUser) throws Exception;

    int removeSysUserById(Long id) throws Exception;

    List<SysUser> findSysUserList(SysUser sysUser) throws Exception;

    SysUser findSysUserByLoginName(String loginName) throws Exception;

    DataGridResult<SysUser> findSysUserListPage(SysUser sysUser) throws Exception;
}
