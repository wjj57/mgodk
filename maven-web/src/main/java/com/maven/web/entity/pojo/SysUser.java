package com.maven.web.entity.pojo;

import com.maven.web.entity.basevo.BaseTimeVo;

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


    @Override
    public String toString() {
        return "SysUser{" +
                "userId=" + userId +
                ", loginName='" + loginName + '\'' +
                ", password='" + password + '\'' +
                ", userName='" + userName + '\'' +
                ", nickName='" + nickName + '\'' +
                ", sex=" + sex +
                ", phone='" + phone + '\'' +
                ", status=" + status +
                ", loginIp='" + loginIp + '\'' +
                ", loginTime=" + loginTime +
                ", roleList=" + roleList +
                '}';
    }
    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public String getLoginName() {
        return loginName;
    }
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getNickName() {
        return nickName;
    }
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    public Integer getSex() {
        return sex;
    }
    public void setSex(Integer sex) {
        this.sex = sex;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }
    public String getLoginIp() {
        return loginIp;
    }
    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }
    public Date getLoginTime() {
        return loginTime;
    }
    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }
    public List<SysRole> getRoleList() {
        return roleList;
    }
    public void setRoleList(List<SysRole> roleList) {
        this.roleList = roleList;
    }
}
