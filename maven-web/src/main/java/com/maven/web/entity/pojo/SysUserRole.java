package com.maven.web.entity.pojo;

import com.maven.web.entity.basevo.PageVo;

/**
 * @ClassName SysUserRole
 * @Description sys_user_role 数据库实体类
 * @Author WJJ
 * @Date 2020/10/16 09:37
 * @Version 1.0
 */
public class SysUserRole extends PageVo {
    /** 用户id */
    private Integer userId ;

    /** 角色id */
    private Integer roleId ;


    @Override
    public String toString() {
        return "SysUserRole{" +
                "userId=" + userId +
                ", roleId=" + roleId +
                '}';
    }
    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public Integer getRoleId() {
        return roleId;
    }
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}
