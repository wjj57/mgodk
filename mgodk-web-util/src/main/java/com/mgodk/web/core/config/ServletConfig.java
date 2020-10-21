package com.mgodk.web.core.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.ssi.SSIServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

/**
 * @ClassName ServletConfig
 * @Description
 * @Author WJJ
 * @Date 2020/10/20 16:14
 * @Version 1.0
 */
@Slf4j
@Configuration
public class ServletConfig {

    /** 注册Servlet三大组件之 Filter */
    @Bean
    public FilterRegistrationBean myFilterRegistrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new Filter() {
            @Override
            public void init(FilterConfig filterConfig) throws ServletException {
                log.info("ServletConfig =》 注册Servlet三大组件之 Filter -- init");
            }
            @Override
            public void destroy() {
                log.info("ServletConfig =》 注册Servlet三大组件之 Filter -- destroy");
            }
            @Override
            public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
                filterChain.doFilter(servletRequest,servletResponse);
                log.info("ServletConfig =》 注册Servlet三大组件之 Filter -- doFilter");
            }
        });
        registrationBean.setUrlPatterns(Arrays.asList("/webServlet","/webFilter"));
        return registrationBean;
    }

    /** 注册Servlet三大组件之 Listener */
    @Bean
    public ServletListenerRegistrationBean myServletListenerRegistrationBean() {
        ServletListenerRegistrationBean<ServletContextListener> registrationBean = new ServletListenerRegistrationBean<>();
        ServletContextListener listener = new ServletContextListener() {
            @Override
            public void contextInitialized(ServletContextEvent sce) {
                log.info("ServletConfig =》 注册Servlet三大组件之 Listener -- contextInitialized...web应用启动！");
            }
            @Override
            public void contextDestroyed(ServletContextEvent sce) {
                log.info("ServletConfig =》 注册Servlet三大组件之 Listener -- contextDestroyed...web应用销毁！");
            }
        };
        registrationBean.setListener(listener);
        return registrationBean;
    }

    /** 注册Servlet三大组件之 Servlet */
    @Bean
    public ServletRegistrationBean myServletRegistrationBean() {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean();
        HttpServlet httpServlet = new SSIServlet() {
            @Override
            public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
                super.doGet(req, res);
                log.info("ServletConfig =》 注册Servlet三大组件之 Servlet -- doGet");
            }
            @Override
            public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
                super.doPost(req, res);
                log.info("ServletConfig =》 注册Servlet三大组件之 Servlet -- doPost");
            }
            @Override
            protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                super.doPut(req, resp);
                log.info("ServletConfig =》 注册Servlet三大组件之 Servlet -- doPut");
            }
            @Override
            protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                super.doDelete(req, resp);
                log.info("ServletConfig =》 注册Servlet三大组件之 Servlet -- doDelete");
            }
        };
        registrationBean.setServlet(httpServlet);
        //Set<String> set = new HashSet<>();
        //set.add("/webServlet");
        //registrationBean.setUrlMappings(set);
        registrationBean.setUrlMappings(Arrays.asList("/webServlet"));
        return registrationBean;
    }
}
