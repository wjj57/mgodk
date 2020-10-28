package com.mgodk.web.core.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @ClassName SystemListener
 * @Description 系统监听者
 * @Author WJJ
 * @Date 2020/10/23 11:54
 * @Version 1.0
 */
@Slf4j
//@Component
public class SystemListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext());
        log.info("获取 WebApplicationContext：[" + context + "]，加载完毕");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext());
        log.info("获取 WebApplicationContext：[" + context + "]，销毁完毕");
    }
}
