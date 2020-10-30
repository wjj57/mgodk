package com.maven.web.entity.pojo;

import com.maven.web.entity.basevo.PageVo;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.EqualsAndHashCode;
//import lombok.NoArgsConstructor;
//import lombok.experimental.Accessors;

/**
 * @ClassName SysRoleMenu
 * @Description sys_role_menu 数据库实体类
 * @Author WJJ
 * @Date 2020/10/16 09:37
 * @Version 1.0
 */
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Accessors(chain = true)
//@EqualsAndHashCode(callSuper = true)
public class SysRoleMenu extends PageVo {
    /** 角色id */
    private Integer roleId ;

    /** 菜单id */
    private Integer menuId ;


    public Integer getRoleId() {
        return roleId;
    }
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
    public Integer getMenuId() {
        return menuId;
    }
    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }
}
