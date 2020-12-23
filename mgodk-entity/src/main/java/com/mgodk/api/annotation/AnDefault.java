package com.mgodk.api.annotation;

import java.lang.annotation.*;

/**
 * @ClassName AnDefault
 * @Description
 * @Author WJJ
 * @Date 2020/10/19 09:08
 * @Version 1.0
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AnDefault {
    String value() default "";
}
