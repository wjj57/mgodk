package com.mgodk.biz.service.impl;

import com.mgodk.api.pojo.SysUser;
import com.mgodk.biz.mapper.SysUserMapper;
import com.mgodk.biz.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName SysUserServiceImpl
 * @Description 业务逻辑功能实现之 系统用户模块
 * @Author WJJ
 * @Date 2020/10/16 17:13
 * @Version 1.0
 */
@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public List<SysUser> findList(SysUser sysUser) throws Exception {
        return sysUserMapper.selectAll();
    }
}
