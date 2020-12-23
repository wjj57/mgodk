package com.mgodk.web.core.aspect;

import com.mgodk.api.pojo.SysUser;
import com.mgodk.web.core.common.Constant;
import com.mgodk.web.core.util.ServletContextUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @ClassName PublicFieldAspect
 * @Description 公共属性：createTime、createBy、updateTime、updateBy
 * @Author WJJ
 * @Date 2020/12/23 16:16
 * @Version 1.0
 */
@Component
@Aspect
public class PublicFieldAspect {
    //private Logger logger = LoggerFactory.getLogger(PublicFieldAspect.class);

    /** 新增 切入点 */
    @Pointcut("execution(* com.mgodk.biz.mapper.*Mapper.insert*(..))")
    public void insertInfo() {}

    /** 修改 切入点 */
    @Pointcut("execution(* com.mgodk.biz.mapper.*Mapper.update*(..))")
    public void updateInfo() {}


    /** 环绕通知：新增属性赋值 */
    @Around("insertInfo()")
    public Object insertAround(ProceedingJoinPoint pjp) throws Throwable {
        SysUser sysUser = (SysUser) ServletContextUtil.getSession().getAttribute(Constant.SESSION_USER_INFO);
        Object obj = pjp.getArgs()[0];
        List<Field> fields = getFieldAll(obj);
        for (Field field : fields) {
            field.setAccessible(true);
            if ("createBy".equals(field.getName())) {
                field.set(obj,new Date());
            }
            if ("createTime".equals(field.getName())) {
                field.set(obj,sysUser.getLoginName());
            }
        }
        return pjp.proceed();
    }

    /** 环绕通知：修改属性赋值 */
    @Around("updateInfo()")
    public Object updateAround(ProceedingJoinPoint pjp) throws Throwable {
        SysUser sysUser = (SysUser) ServletContextUtil.getSession().getAttribute(Constant.SESSION_USER_INFO);
        Object obj = pjp.getArgs()[0];
        List<Field> fields = getFieldAll(obj);
        for (Field field : fields) {
            field.setAccessible(true);
            if ("updateBy".equals(field.getName())) {
                field.set(obj,new Date());
            }
            if ("updateTime".equals(field.getName())) {
                field.set(obj,sysUser.getLoginName());
            }
        }
        return pjp.proceed();
    }


    /** 获取 对象所有属性 */
    private List<Field> getFieldAll(Object obj) {
        Class<?> clazz = obj.getClass();
        List<Field> fields = new ArrayList<>();
        while (Object.class != obj) {
            fields.addAll(Arrays.asList(clazz.getDeclaredFields()));
            clazz = clazz.getSuperclass();
        }
        return fields;
    }
}
