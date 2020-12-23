package com.mgodk.web.core.annotation;

import com.mgodk.web.core.common.BusinessType;

import java.lang.annotation.*;

/**
 * @ClassName AnLog
 * @Description
 * @Author WJJ
 * @Date 2020/12/22 10:45
 * @Version 1.0
 */
@Target({ElementType.METHOD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AnLog {
    /** 模块 */
    String title() default "";
    /** 功能 */
    BusinessType businessType() default BusinessType.OTHER;
    /** 是否 保存请求的参数 */
    boolean isSaveRequestData() default true;
    /** 是否 保存响应的结果 */
    boolean isSaveResponseData() default true;
}
