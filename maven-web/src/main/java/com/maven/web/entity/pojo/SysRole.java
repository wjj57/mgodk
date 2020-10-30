package com.maven.web.entity.pojo;

import com.maven.web.entity.basevo.BaseTimeVo;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.EqualsAndHashCode;
//import lombok.NoArgsConstructor;
//import lombok.experimental.Accessors;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.List;

/**
 * @ClassName SysRole
 * @Description sys_role 数据库实体类
 * @Author WJJ
 * @Date 2020/10/16 09:36
 * @Version 1.0
 */
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Accessors(chain = true)
//@EqualsAndHashCode(callSuper = true)
public class SysRole extends BaseTimeVo {
    /** id标识;自增 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roleId ;

    /** 角色名称 */
    private String roleName ;

    /** 权限标识符;唯一 */
    private String power ;

    /** 账号状态;0启用，1 禁用 */
    private Integer status ;

    /** 备注;描述 */
    private String remark ;

    /** 临时属性：所拥有菜单权限 */
    @Transient
    private List<SysMenu> menuList;


    public Integer getRoleId() {
        return roleId;
    }
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
    public String getRoleName() {
        return roleName;
    }
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
    public String getPower() {
        return power;
    }
    public void setPower(String power) {
        this.power = power;
    }
    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }
    public String getRemark() {
        return remark;
    }
    public void setRemark(String remark) {
        this.remark = remark;
    }
    public List<SysMenu> getMenuList() {
        return menuList;
    }
    public void setMenuList(List<SysMenu> menuList) {
        this.menuList = menuList;
    }
}
