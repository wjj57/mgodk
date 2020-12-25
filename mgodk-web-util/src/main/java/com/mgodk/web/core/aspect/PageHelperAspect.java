package com.mgodk.web.core.aspect;

import com.github.pagehelper.PageHelper;
import com.mgodk.api.basevo.PageVo;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @ClassName PageHelperAspect
 * @Description 分页拦截
 * @Author WJJ
 * @Date 2020/10/20 15:52
 * @Version 1.0
 */
@Component
@Aspect
public class PageHelperAspect {
    //private Logger logger = LoggerFactory.getLogger(PageHelperAspect.class);

    //execution([方法的可见性] 返回类型 [方法所在类的全路径名] 方法名(参数类型列表) [方法抛出的异常类型])
    /** 分页查询 切入点 */
    @Pointcut("execution(com.mgodk.api.common.DataGridResult com.mgodk.biz.service.*Service.*Page*(..))")
    public void pageInfo() {}


    /** 环绕通知：分页 */
    @Around("pageInfo()")
    public Object pageInfo(ProceedingJoinPoint pjp) throws Throwable {
        Object o = pjp.getArgs()[0];
        if(o instanceof PageVo){
            PageVo pageVo = (PageVo)o;
            Integer pageNumber = pageVo.getPageNumber();
            Integer pageSize = pageVo.getPageSize();
            if (pageNumber == null) {
                pageNumber = 1;
            }
            if (pageSize == null) {
                pageSize = 10;
            }
            PageHelper.startPage(pageNumber, pageSize);
        }
        return pjp.proceed();
    }
}
