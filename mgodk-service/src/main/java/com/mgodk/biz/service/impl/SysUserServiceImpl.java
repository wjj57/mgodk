package com.mgodk.biz.service.impl;

import com.mgodk.api.pojo.SysUser;
import com.mgodk.biz.mapper.SysUserMapper;
import com.mgodk.biz.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName SysUserServiceImpl
 * @Description 业务逻辑功能实现之 系统用户模块
 * @Author WJJ
 * @Date 2020/10/16 17:13
 * @Version 1.0
 */
@Service
@Slf4j
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    @Transactional
    public List<SysUser> findList(SysUser sysUser) throws Exception {
        log.debug("Service层 》 debug");
        log.info("Service层 》 info");
        log.warn("Service层 》 warn");
        log.error("Service层 》 error");
        return sysUserMapper.selectAll();
    }
}
