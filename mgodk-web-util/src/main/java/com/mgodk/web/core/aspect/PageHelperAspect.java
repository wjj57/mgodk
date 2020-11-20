package com.mgodk.web.core.aspect;

import com.github.pagehelper.PageHelper;
import com.mgodk.api.basevo.PageVo;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @ClassName PageHelperAspect
 * @Description 分页拦截
 * @Author WJJ
 * @Date 2020/10/20 15:52
 * @Version 1.0
 */
@Slf4j
//@Component
//@Aspect
public abstract class PageHelperAspect {
    //execution([方法的可见性] 返回类型 [方法所在类的全路径名] 方法名(参数类型列表) [方法抛出的异常类型])
    @Pointcut("execution(com.mgodk.api.common.DataGridResult com.mgodk.biz.service.*Service.*Page*(..))")
    public void pageInfo() {}

    @Around("pageInfo()")
    public Object pageInfo(ProceedingJoinPoint pjp) throws Throwable {
        Object o=pjp.getArgs()[0];
        if(o instanceof PageVo){
            PageVo pageVo = (PageVo)o;
            PageHelper.startPage(pageVo.getPageNumber(), pageVo.getPageSize());
        }
        return pjp.proceed();
    }
}
