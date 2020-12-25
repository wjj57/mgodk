package com.mgodk.biz.service.impl;

import com.github.pagehelper.PageInfo;
import com.mgodk.api.common.DataGridResult;
import com.mgodk.api.exception.GlobalException;
import com.mgodk.api.pojo.SysMenu;
import com.mgodk.biz.mapper.SysMenuMapper;
import com.mgodk.biz.service.SysMenuService;
import com.mgodk.biz.util.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @ClassName SysMenuServiceImpl
 * @Description 业务逻辑之 系统菜单模块实现
 * @Author WJJ
 * @Date 2020/10/19 11:37
 * @Version 1.0
 */
@Service
public class SysMenuServiceImpl implements SysMenuService {
    @Autowired
    private SysMenuMapper sysMenuMapper;
    @Autowired
    private IdWorker idWorker;

    @Override
    public int saveSysMenu(SysMenu sysMenu) throws Exception {
        if (findSysMenuByPower(sysMenu.getPower()) != null) {
            throw new  GlobalException("该菜单标识符已存在");
        }
        sysMenu.setMenuId(idWorker.nextId());
        return sysMenuMapper.insert(sysMenu);
    }

    @Override
    public int modifySysMenuById(SysMenu sysMenu) throws Exception {
        if (findSysMenuByPower(sysMenu.getPower()) != null) {
            throw new  GlobalException("该菜单标识符已存在");
        }
        return sysMenuMapper.updateByPrimaryKey(sysMenu);
    }

    @Override
    public int removeSysMenuById(Long id) throws Exception {
        return sysMenuMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<SysMenu> findSysMenuList(SysMenu sysMenu) throws Exception {
        Example example = new Example(SysMenu.class);
        Example.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(sysMenu.getMenuName())) {
            criteria.andLike("menuName","%" + sysMenu.getMenuName() + "%");
        }
        if (!StringUtils.isEmpty(sysMenu.getStatus())) {
            criteria.andEqualTo("status",sysMenu.getStatus());
        }
        return sysMenuMapper.selectByExample(example);
    }

    @Override
    public DataGridResult<SysMenu> findSysMenuListPage(SysMenu sysMenu) throws Exception {
        List<SysMenu> sysMenuList = findSysMenuList(sysMenu);
        PageInfo<SysMenu> pageInfo = new PageInfo<>(sysMenuList);
        return new DataGridResult<>(pageInfo.getTotal(),pageInfo.getList());
    }

    @Override
    public SysMenu findSysMenuByPower(String power) throws Exception {
        Example example = new Example(SysMenu.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("power",power);
        return sysMenuMapper.selectOneByExample(example);
    }
}
