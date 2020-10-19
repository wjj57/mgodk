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
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;

/**
 * @ClassName SysUser
 * @Description sys_user 数据库实体类
 * @Author WJJ
 * @Date 2020/09/07 16:58
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class SysUser extends BaseTimeVo {
    /** id标识;自增 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId ;

    /** 登录名;唯一 */
    @NotBlank(message = "登录名 不能为空")
    private String loginName ;

    /** 密码;加密 */
    private String password ;

    /** 名字;唯一 */
    private String userName ;

    /** 昵称;网名 */
    private String nickName ;

    /** 性别;0 男，1 女 */
    private Integer sex ;

    /** 手机号 */
    private String phone ;

    /** 状态;0 启用，1禁用 */
    private Integer status ;

    /** 登录地址 */
    private String loginIp ;

    /** 上次登录时间 */
    private Date loginTime ;


    /** 临时属性：所拥有角色 */
    @Transient
    private List<SysRole> roleList;
}
