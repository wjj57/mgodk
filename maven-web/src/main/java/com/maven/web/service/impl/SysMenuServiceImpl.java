package com.maven.web.service.impl;

import com.maven.web.mapper.SysMenuMapper;
import com.maven.web.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
