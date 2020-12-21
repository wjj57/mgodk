package com.mgodk.web.core.config;

import com.mgodk.web.core.interceptor.LoginHandlerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName WebMvcConfiguration
 * @Description SpringMvc 配置
 * @Author WJJ
 * @Date 2020/10/20 16:09
 * @Version 1.0
 * 注：@Configuration 表示对SpringMvc配置的扩展；
 * 使用@EnableWebMvc 表示舍弃SpringBoot对SpringMvc的自动配置，全部使用我们自己的配置，推荐不使用此注解；
 */
@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {
    /** 配置 拦截器 */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        String[] exclude = {"/static/**","/js/**","/css/**","/font/**","/fonts/**","/image/**",
                "/","/login","/login.html","/register","/register.html",
                "/authentication/form","/authentication/register"};
        registry.addInterceptor(new LoginHandlerInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns(exclude);
    }

    /** 配置 资源处理 */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
//        registry.addResourceHandler("/templates/**").addResourceLocations("classpath:/templates/");
    }

    /** 配置 视图控制器，自定义请求响应视图名称；
     * 还可以创建 WebMvcConfigurer 的 bean 对象方法，进行重写 addViewControllers 方法，与其它组件一同生效；
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("redirect:/login");
        registry.addViewController("/error").setViewName("/error/error");
        registry.addViewController("/login").setViewName("/login");
        registry.addViewController("/login.html").setViewName("forward:/page/login");
        registry.addViewController("/register").setViewName("/register");
        registry.addViewController("/register.html").setViewName("forward:/page/register");
        registry.addViewController("/index").setViewName("/index");
        registry.addViewController("/index.html").setViewName("forward:/page/index");
    }
}
