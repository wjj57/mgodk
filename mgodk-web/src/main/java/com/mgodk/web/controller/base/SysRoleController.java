package com.mgodk.web.controller.base;

import com.mgodk.api.common.DataGridResult;
import com.mgodk.api.common.ReturnResult;
import com.mgodk.api.pojo.SysMenu;
import com.mgodk.api.pojo.SysRole;
import com.mgodk.biz.service.SysRoleService;
import com.mgodk.web.core.annotation.AnLog;
import com.mgodk.web.core.common.BusinessType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName SysRoleController
 * @Description 角色信息 模块管理
 * @Author WJJ
 * @Date 2020/12/23 17:12
 * @Version 1.0
 */
@RestController
@RequestMapping("/sysUser")
public class SysRoleController {
    @Autowired
    private SysRoleService sysRoleService;

    @AnLog(title = "角色管理 - 列表查询",businessType = BusinessType.SELECT)
    @GetMapping(value = "/getList")
    public List<SysRole> getList(SysRole sysRole) throws Exception {
        return null;
    }

    @AnLog(title = "角色管理 - 分页查询",businessType = BusinessType.SELECT)
    @GetMapping(value = "/getPage")
    public DataGridResult<SysRole> getPage(SysRole sysRole) throws Exception {
        return null;
    }

    @AnLog(title = "角色管理 - 添加角色信息",businessType = BusinessType.INSERT)
    @PostMapping(value = "/add")
    public ReturnResult add(SysRole sysRole) {
        return ReturnResult.success("");
    }

    @AnLog(title = "角色管理 - 修改角色信息",businessType = BusinessType.UPDATE)
    @PostMapping(value = "/edit")
    public ReturnResult edit(SysRole sysRole) {
        return ReturnResult.success("");
    }

    @AnLog(title = "角色管理 - 删除角色信息，通过 ID 标识",businessType = BusinessType.DELETE)
    @PostMapping(value = "/del")
    public ReturnResult del(Long id) {
        return ReturnResult.success("");
    }
}
