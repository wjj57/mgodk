package com.mgodk.entity.pojo;

import com.mgodk.entity.basevo.PageVo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @ClassName SysUserRole
 * @Description sys_user_role 数据库实体类
 * @Author WJJ
 * @Date 2020/10/16 09:37
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class SysUserRole extends PageVo {
    /** 用户id */
    private Integer userId ;

    /** 角色id */
    private Integer roleId ;
}
