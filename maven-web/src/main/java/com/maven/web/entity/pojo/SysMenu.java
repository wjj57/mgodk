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

/**
 * @ClassName SysMenu
 * @Description sys_menu 数据库实体类
 * @Author WJJ
 * @Date 2020/10/16 09:37
 * @Version 1.0
 */
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Accessors(chain = true)
//@EqualsAndHashCode(callSuper = true)
public class SysMenu extends BaseTimeVo {
    /** id标识;自增 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer menuId ;

    /** 菜单名称 */
    private String menuName ;

    /** 菜单权限字符串;唯一 */
    private String power ;

    /** 父菜单id */
    private Integer parentId ;

    /** 请求路径地址 */
    private String targetUrl ;

    /** 菜单图标 */
    private String icon ;

    /** 状态;0启用，1 禁用 */
    private Integer status ;


    public Integer getMenuId() {
        return menuId;
    }
    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }
    public String getMenuName() {
        return menuName;
    }
    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }
    public String getPower() {
        return power;
    }
    public void setPower(String power) {
        this.power = power;
    }
    public Integer getParentId() {
        return parentId;
    }
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
    public String getTargetUrl() {
        return targetUrl;
    }
    public void setTargetUrl(String targetUrl) {
        this.targetUrl = targetUrl;
    }
    public String getIcon() {
        return icon;
    }
    public void setIcon(String icon) {
        this.icon = icon;
    }
    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }
}
