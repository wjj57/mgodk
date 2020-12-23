package com.mgodk.web.core.aspect;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mgodk.biz.util.IpUtil;
import com.mgodk.web.core.annotation.AnLog;
import com.mgodk.web.core.common.BusinessType;
import com.mgodk.web.core.util.ServletContextUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * @ClassName LogAspect
 * @Description 日志记录
 * @Author WJJ
 * @Date 2020/10/20 15:58
 * @Version 1.0
 * 注：对于 Controller 层自定义的日志信息，只进行了获取，还没有进行处理
 */
@Component
@Aspect
public class LogAspect {
    //private Logger logger = LoggerFactory.getLogger(LogAspect.class);
    private ObjectMapper objectMapper = new ObjectMapper();

    /** 日志注解 切入点 */
    @Pointcut("@annotation(com.mgodk.web.core.annotation.AnLog)")
    public void logInfo() {}


    /** 返回后通知：处理完请求后执行 */
    @AfterReturning(pointcut = "logInfo()", returning = "jsonResult")
    public void doAfterReturning(JoinPoint joinPoint, Object jsonResult) {
        handleLog(joinPoint,jsonResult,null);
    }

    /** 抛出异常通知：拦截异常操作 */
    @AfterThrowing(pointcut = "logInfo()", throwing = "ex")
    public void doAfterThrowing(JoinPoint joinPoint, Exception ex) {
        handleLog(joinPoint,null,ex);
    }


    /** 通用处理日志方法 */
    public void handleLog(JoinPoint joinPoint, Object jsonResult, Exception ex) {
        AnLog anLog;
        // 判断 请求处理方法上是否存在日志注解，如果存在就处理日志信息
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        if (method != null) {
            anLog = method.getAnnotation(AnLog.class);
        } else {
            anLog = null;
        }
        if (anLog == null) {
            return;
        }
        // 获取 日志信息
        String ip = IpUtil.getIpAddr(ServletContextUtil.getRequest());
        String url = ServletContextUtil.getRequest().getRequestURI();
        String methodStr = ServletContextUtil.getRequest().getMethod();
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        String message;
        if (ex != null) {
            message = ex.getMessage();
        }
        // 获取 注解携带的信息
        String title = anLog.title();
        String businessTypeName = anLog.businessType().name();
        BusinessType businessType = anLog.businessType();
        // 判断日志 是否保存请求参数、是否保存响应信息
        if (anLog.isSaveRequestData()) {
            //获取请求的参数，放到log中
            Map<String, String[]> map = ServletContextUtil.getRequest().getParameterMap();
            try {
                String jsonRequest = objectMapper.writeValueAsString(map);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
    }
}
