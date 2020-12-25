package com.mgodk.biz.service.impl;

import com.github.pagehelper.PageInfo;
import com.mgodk.api.common.DataGridResult;
import com.mgodk.api.exception.GlobalException;
import com.mgodk.api.pojo.SysRole;
import com.mgodk.biz.mapper.SysRoleMapper;
import com.mgodk.biz.service.SysRoleService;
import com.mgodk.biz.util.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

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
    @Autowired
    private IdWorker idWorker;

    @Override
    public int saveSysRole(SysRole sysRole) throws Exception {
        if (findSysRoleByPower(sysRole.getPower()) != null) {
            throw new GlobalException("该角色标识符已存在");
        }
        sysRole.setRoleId(idWorker.nextId());
        return sysRoleMapper.insert(sysRole);
    }

    @Override
    public int modifySysRoleById(SysRole sysRole) throws Exception {
        if (findSysRoleByPower(sysRole.getPower()) != null) {
            throw new GlobalException("该角色标识符已存在");
        }
        return sysRoleMapper.updateByPrimaryKey(sysRole);
    }

    @Override
    public int removeSysRoleById(Long id) throws Exception {
        return sysRoleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<SysRole> findSysRoleList(SysRole sysRole) throws Exception {
        Example example = new Example(SysRole.class);
        Example.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(sysRole.getRoleName())) {
            criteria.andLike("roleName","%" + sysRole.getRoleName() + "%");
        }
        if (!StringUtils.isEmpty(sysRole.getStatus())) {
            criteria.andEqualTo("status",sysRole.getStatus());
        }
        return sysRoleMapper.selectByExample(example);
    }

    @Override
    public DataGridResult<SysRole> findSysRoleListPage(SysRole sysRole) throws Exception {
        List<SysRole> sysRoleList = findSysRoleList(sysRole);
        PageInfo<SysRole> pageInfo = new PageInfo<>(sysRoleList);
        return new DataGridResult<>(pageInfo.getTotal(),pageInfo.getList());
    }

    @Override
    public SysRole findSysRoleByPower(String power) throws Exception {
        Example example = new Example(SysRole.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("power",power);
        return sysRoleMapper.selectOneByExample(example);
    }
}
