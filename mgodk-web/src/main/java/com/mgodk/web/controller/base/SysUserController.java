package com.mgodk.web.controller.base;

import com.mgodk.api.common.DataGridResult;
import com.mgodk.api.common.ResponseData;
import com.mgodk.api.common.ReturnResult;
import com.mgodk.api.pojo.SysUser;
import com.mgodk.biz.service.SysUserService;
import com.mgodk.web.core.annotation.AnLog;
import com.mgodk.web.core.common.BusinessType;
import com.mgodk.web.core.common.Constant;
import com.mgodk.web.core.security.PasswordEncoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * @ClassName SysUserController
 * @Description 用户信息 模块管理
 * @Author WJJ
 * @Date 2020/10/19 14:47
 * @Version 1.0
 */
@RestController
@RequestMapping("/sysUser")
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @AnLog(title = "用户管理 - 列表查询",businessType = BusinessType.SELECT)
    @GetMapping(value = "/getList")
    public List<SysUser> getList(SysUser sysUser) throws Exception {
        return sysUserService.findSysUserList(sysUser);
    }

    @AnLog(title = "用户管理 - 分页查询",businessType = BusinessType.SELECT)
    @GetMapping(value = "/getPage")
    public DataGridResult<SysUser> getPage(SysUser sysUser) throws Exception {
        return sysUserService.findSysUserListPage(sysUser);
    }

    @AnLog(title = "用户管理 - 添加用户信息",businessType = BusinessType.INSERT)
    @PostMapping(value = "/add")
    public ReturnResult add(SysUser sysUser) {
        try {
            sysUser.setPassword(passwordEncoder.encode(sysUser.getPassword()));
            boolean flag = sysUserService.saveSysUser(sysUser) > 0;
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

    @AnLog(title = "用户管理 - 修改用户信息",businessType = BusinessType.UPDATE)
    @PostMapping(value = "/edit")
    public ReturnResult edit(SysUser sysUser) {
        try {
            boolean flag = sysUserService.modifySysUserById(sysUser) > 0;
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

    @AnLog(title = "用户管理 - 删除用户信息，通过 ID 标识",businessType = BusinessType.DELETE)
    @PostMapping(value = "/del")
    public ReturnResult del(Long id) {
        try {
            boolean flag = sysUserService.removeSysUserById(id) > 0;
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



    @AnLog(title = "用户管理 - 导入表格数据",businessType = BusinessType.IMPORT)
    @PostMapping(value = "/import",produces="text/html;charset=UTF-8")
    public String importExcel(@RequestParam("file") MultipartFile file) throws Exception {
        return "";
    }
    @AnLog(title = "用户管理 - 导出表格数据",businessType = BusinessType.EXPORT)
    @PostMapping(value = "/export",produces="text/html;charset=UTF-8")
    public String exportExcel() throws Exception {
        return "";
    }
}
