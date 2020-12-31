package com.mgodk.web.core.filter;

import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName CorsFilter
 * @Description Cors 过滤器
 * @Author WJJ
 * @Date 2020/12/29 16:20
 * @Version 1.0
 * 注：主要是为了解决跨域问题，方法如下
 * 1、自定义 WebMvcConfigurer 的实现类，重写 addCorsMappings 方法
 * 2、自定义 Cors 过滤器
 * 3、使用注解 @CrossOrigin(origins="http://localhost:8080") 使用在 Controller 层的类或方法上
 */
//@Configuration
//@WebFilter(filterName = "CorsFilter")
public class CorsFilter implements Filter {
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//
//    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse res = (HttpServletResponse) response;
        res.setHeader("Access-Control-Allow-Origin","*");
        res.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, PATCH");
        res.setHeader("Access-Control-Allow-Credentials", "true");
        res.setHeader("Access-Control-Max-Age", "3600");
        res.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
        chain.doFilter(request, response);
    }

//    @Override
//    public void destroy() {
//
//    }
}
