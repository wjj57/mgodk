package com.maven.web.entity.exception;

/**
 * @ClassName GlobalException
 * @Description 全局异常运行时异常 捕捉处理类
 * @Author WJJ
 * @Date 2020/09/07 15:25
 * @Version 1.0
 */
public class GlobalException extends RuntimeException {
    private String msg;

    public GlobalException(String msg){
        super(msg);
    }
}
