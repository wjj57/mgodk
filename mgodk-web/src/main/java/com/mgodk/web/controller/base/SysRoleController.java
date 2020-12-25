package com.mgodk.web.controller.base;

import com.mgodk.api.common.DataGridResult;
import com.mgodk.api.common.ReturnResult;
import com.mgodk.api.pojo.SysMenu;
import com.mgodk.api.pojo.SysRole;
import com.mgodk.biz.service.SysRoleService;
import com.mgodk.web.core.annotation.AnLog;
import com.mgodk.web.core.common.BusinessType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @ClassName SysRoleController
 * @Description 角色信息 模块管理
 * @Author WJJ
 * @Date 2020/12/23 17:12
 * @Version 1.0
 */
@RestController
@RequestMapping("/sysRole")
public class SysRoleController {
    @Autowired
    private SysRoleService sysRoleService;

    @AnLog(title = "角色管理 - 列表查询",businessType = BusinessType.SELECT)
    @GetMapping(value = "/getList")
    public List<SysRole> getList(SysRole sysRole) throws Exception {
        return sysRoleService.findSysRoleList(sysRole);
    }

    @AnLog(title = "角色管理 - 分页查询",businessType = BusinessType.SELECT)
    @GetMapping(value = "/getPage")
    public DataGridResult<SysRole> getPage(SysRole sysRole) throws Exception {
        return sysRoleService.findSysRoleListPage(sysRole);
    }

    @AnLog(title = "角色管理 - 添加角色信息",businessType = BusinessType.INSERT)
    @PostMapping(value = "/add")
    public ReturnResult add(SysRole sysRole) {
        try {
            boolean flag = sysRoleService.saveSysRole(sysRole) > 0;
            if (flag) {
                return ReturnResult.success("添加成功");
            } else {
                return ReturnResult.failure("添加失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ReturnResult.failure("系统错误 ：" + e.getMessage());
        }
    }

    @AnLog(title = "角色管理 - 修改角色信息",businessType = BusinessType.UPDATE)
    @PostMapping(value = "/edit")
    public ReturnResult edit(SysRole sysRole) {
        try {
            boolean flag = sysRoleService.modifySysRoleById(sysRole) > 0;
            if (flag) {
                return ReturnResult.success("修改成功");
            } else {
                return ReturnResult.failure("修改失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ReturnResult.failure("系统错误 ：" + e.getMessage());
        }
    }

    @AnLog(title = "角色管理 - 删除角色信息，通过 ID 标识",businessType = BusinessType.DELETE)
    @PostMapping(value = "/del")
    public ReturnResult del(Long id) {
        try {
            boolean flag = sysRoleService.removeSysRoleById(id) > 0;
            if (flag) {
                return ReturnResult.success("删除成功");
            } else {
                return ReturnResult.failure("删除失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ReturnResult.failure("系统错误 ：" + e.getMessage());
        }
    }



    @AnLog(title = "角色管理 - 导入表格数据",businessType = BusinessType.IMPORT)
    @PostMapping(value = "/import",produces="text/html;charset=UTF-8")
    public String importExcel(@RequestParam("file") MultipartFile file) throws Exception {
        return "";
    }
    @AnLog(title = "角色管理 - 导出表格数据",businessType = BusinessType.EXPORT)
    @PostMapping(value = "/export",produces="text/html;charset=UTF-8")
    public String exportExcel() throws Exception {
        return "";
    }
}
