package com.maven.web.service;

import com.maven.web.entity.pojo.SysUser;

import java.util.List;

/**
 * @ClassName SysUserService
 * @Description 业务逻辑之 系统用户模块
 * @Author WJJ
 * @Date 2020/10/16 11:22
 * @Version 1.0
 * add/save,del/remove,edit/modify,get/find - batch/count/one/list/all/page/by
 */
public interface SysUserService {
    List<SysUser> findList(SysUser sysUser) throws Exception;
}
