package com.mgodk.web.controller.base;

import com.mgodk.api.common.DataGridResult;
import com.mgodk.api.common.ReturnResult;
import com.mgodk.api.pojo.SysMenu;
import com.mgodk.biz.service.SysMenuService;
import com.mgodk.web.core.annotation.AnLog;
import com.mgodk.web.core.common.BusinessType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName SysMenuController
 * @Description 菜单信息 模块管理
 * @Author WJJ
 * @Date 2020/12/23 17:12
 * @Version 1.0
 */
@RestController
@RequestMapping("/sysMenu")
public class SysMenuController {
    @Autowired
    private SysMenuService sysMenuService;

    @AnLog(title = "菜单管理 - 列表查询",businessType = BusinessType.SELECT)
    @GetMapping(value = "/getList")
    public List<SysMenu> getList(SysMenu sysMenu) throws Exception {
        return null;
    }

    @AnLog(title = "菜单管理 - 分页查询",businessType = BusinessType.SELECT)
    @GetMapping(value = "/getPage")
    public DataGridResult<SysMenu> getPage(SysMenu sysMenu) throws Exception {
        return null;
    }

    @AnLog(title = "菜单管理 - 添加菜单信息",businessType = BusinessType.INSERT)
    @PostMapping(value = "/add")
    public ReturnResult add(SysMenu sysMenu) {
        return ReturnResult.success("");
    }

    @AnLog(title = "菜单管理 - 修改菜单信息",businessType = BusinessType.UPDATE)
    @PostMapping(value = "/edit")
    public ReturnResult edit(SysMenu sysMenu) {
        return ReturnResult.success("");
    }

    @AnLog(title = "菜单管理 - 删除菜单信息，通过 ID 标识",businessType = BusinessType.DELETE)
    @PostMapping(value = "/del")
    public ReturnResult del(Long id) {
        return ReturnResult.success("");
    }
}
