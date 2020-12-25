package com.mgodk.biz.sersvice.impl;

import com.github.pagehelper.PageInfo;
import com.google.common.base.Strings;
import com.mgodk.api.common.DataGridResult;
import com.mgodk.api.exception.GlobalException;
import com.mgodk.api.pojo.SysUser;
import com.mgodk.biz.common.BaseService;
import com.mgodk.biz.mapper.SysUserMapper;
import com.mgodk.biz.service.SysUserService;
import com.mgodk.biz.util.IdWorker;
import com.mgodk.biz.util.SnowflakeIdWorker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

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
    @Autowired
    private IdWorker idWorker;

    @Override
    public int saveSysUser(SysUser sysUser) throws Exception {
        if (findSysUserByLoginName(sysUser.getLoginName()) != null) {
            throw new GlobalException("账户已存在");
        }
        sysUser.setUserId(idWorker.nextId());
        return sysUserMapper.insert(sysUser);
    }

    @Override
    public int modifySysUserById(SysUser sysUser) throws Exception {
        if (findSysUserByLoginName(sysUser.getLoginName()) != null) {
            throw new GlobalException("账户已存在");
        }
        return sysUserMapper.updateByPrimaryKey(sysUser);
    }

    @Override
    public int removeSysUserById(Long id) throws Exception {
        return sysUserMapper.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional
    public List<SysUser> findSysUserList(SysUser sysUser) throws Exception {
        Example example = new Example(SysUser.class);
        Example.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(sysUser.getLoginName())) {
            criteria.andLike("loginName","%" + sysUser.getLoginName() + "%");
        }
        if (!StringUtils.isEmpty(sysUser.getUserName())) {
            criteria.andLike("userName","%" + sysUser.getUserName() + "%");
        }
        return sysUserMapper.selectByExample(example);
    }

    @Override
    @Transactional
    public SysUser findSysUserByLoginName(String loginName) throws Exception {
        log.debug("Service层 》 debug");
        log.info("Service层 》 info");
        log.warn("Service层 》 warn");
        log.error("Service层 》 error");

        Example example = new Example(SysUser.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("loginName",loginName);
        return sysUserMapper.selectOneByExample(example);
    }

    @Override
    @Transactional
    public DataGridResult<SysUser> findSysUserListPage(SysUser sysUser) throws Exception {
        List<SysUser> sysUserList = findSysUserList(sysUser);
        PageInfo<SysUser> pageInfo = new PageInfo<>(sysUserList);
        return new DataGridResult<>(pageInfo.getTotal(),pageInfo.getList());
    }
}
