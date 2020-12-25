package com.mgodk.web.controller.base;

import com.mgodk.api.common.DataGridResult;
import com.mgodk.api.common.ReturnResult;
import com.mgodk.api.pojo.SysMenu;
import com.mgodk.biz.service.SysMenuService;
import com.mgodk.web.core.annotation.AnLog;
import com.mgodk.web.core.common.BusinessType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
        return sysMenuService.findSysMenuList(sysMenu);
    }

    @AnLog(title = "菜单管理 - 分页查询",businessType = BusinessType.SELECT)
    @GetMapping(value = "/getPage")
    public DataGridResult<SysMenu> getPage(SysMenu sysMenu) throws Exception {
        return sysMenuService.findSysMenuListPage(sysMenu);
    }

    @AnLog(title = "菜单管理 - 添加菜单信息",businessType = BusinessType.INSERT)
    @PostMapping(value = "/add")
    public ReturnResult add(SysMenu sysMenu) {
        try {
            boolean flag = sysMenuService.saveSysMenu(sysMenu) > 0;
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

    @AnLog(title = "菜单管理 - 修改菜单信息",businessType = BusinessType.UPDATE)
    @PostMapping(value = "/edit")
    public ReturnResult edit(SysMenu sysMenu) {
        try {
            boolean flag = sysMenuService.modifySysMenuById(sysMenu) > 0;
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

    @AnLog(title = "菜单管理 - 删除菜单信息，通过 ID 标识",businessType = BusinessType.DELETE)
    @PostMapping(value = "/del")
    public ReturnResult del(Long id) {
        try {
            boolean flag = sysMenuService.removeSysMenuById(id) > 0;
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



    @AnLog(title = "菜单管理 - 导入表格数据",businessType = BusinessType.IMPORT)
    @PostMapping(value = "/import",produces="text/html;charset=UTF-8")
    public String importExcel(@RequestParam("file") MultipartFile file) throws Exception {
        return "";
    }
    @AnLog(title = "菜单管理 - 导出表格数据",businessType = BusinessType.EXPORT)
    @PostMapping(value = "/export",produces="text/html;charset=UTF-8")
    public String exportExcel() throws Exception {
        return "";
    }
}
