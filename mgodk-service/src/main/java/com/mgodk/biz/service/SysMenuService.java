package com.mgodk.biz.service;

import com.mgodk.api.common.DataGridResult;
import com.mgodk.api.pojo.SysMenu;

import java.util.List;

/**
 * @ClassName SysMenuService
 * @Description 业务逻辑之 系统菜单模块
 * @Author WJJ
 * @Date 2020/10/19 11:36
 * @Version 1.0
 */
public interface SysMenuService {
    int saveSysMenu(SysMenu sysMenu) throws Exception;

    int modifySysMenuById(SysMenu sysMenu) throws Exception;

    int removeSysMenuById(Long id) throws Exception;

    List<SysMenu> findSysMenuList(SysMenu sysMenu) throws Exception;

    DataGridResult<SysMenu> findSysMenuListPage(SysMenu sysMenu) throws Exception;

    SysMenu findSysMenuByPower(String power) throws Exception;
}
