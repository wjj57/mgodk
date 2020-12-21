package com.mgodk.api.pojo;

import com.mgodk.api.basevo.BaseTimeVo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

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
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class SysRole extends BaseTimeVo {
    /** id标识;自增 @GeneratedValue(strategy = GenerationType.IDENTITY) */
    @Id
    private Long roleId ;

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
}
