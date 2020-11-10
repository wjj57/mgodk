package com.maven.web.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.maven.web.core.base.BaseMapperService;
import com.maven.web.entity.pojo.SysUser;
import com.maven.web.mapper.SysUserMapper;
import com.maven.web.service.SysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class SysUserServiceImpl extends BaseMapperService<SysUser> implements SysUserService {
    private static final Logger logger = LoggerFactory.getLogger(SysUserServiceImpl.class);

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    @Transactional
    public List<SysUser> findList(SysUser sysUser) throws Exception {
        logger.debug("SysUserServiceImpl_debug");
        logger.info("SysUserServiceImpl_info");
        logger.warn("SysUserServiceImpl_warn");
        logger.error("SysUserServiceImpl_error");
        return sysUserMapper.selectListAll();
    }

}
