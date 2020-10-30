package com.mgodk.web.core.config;

import com.mgodk.web.core.interceptor.LoginHandlerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
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
//        String[] exclude = {"/plugins/**","/js/**","/css/**","/images/**","/fonts**",
//                "/upload","/login"};
//        registry.addInterceptor(null).addPathPatterns("/**").excludePathPatterns(exclude);
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**");
    }

    /** 配置 资源处理 */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/**")
//                .addResourceLocations("classpath:/static/");
    }
}
