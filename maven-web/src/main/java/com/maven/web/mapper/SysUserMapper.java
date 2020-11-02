package com.maven.web.mapper;

import com.maven.web.entity.pojo.SysUser;

import java.util.List;

/**
 * @ClassName SysUserMapper
 * @Description 数据操作之 系统用户数据
 * @Author WJJ
 * @Date 2020/10/16 10:17
 * @Version 1.0
 */
public interface SysUserMapper {//extends BaseMapper<SysUser>
    List<SysUser> selectListAll();
}
