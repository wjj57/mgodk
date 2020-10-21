package com.mgodk.web.core.config;

import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;
import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

import javax.servlet.MultipartConfigElement;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @ClassName WebConfig
 * @Description Web 相关配置
 * @Author WJJ
 * @Date 2020/10/20 17:21
 * @Version 1.0
 */
@Configuration
public class WebConfig {
    /** 配置 Servlet容器
     * 注：SpringBoot2.0以后嵌入式Servlet容器使用WebServerFactoryCustomizer替代了EmbeddedServletContainerCustomizer
     */
    @Bean
    public WebServerFactoryCustomizer<ConfigurableWebServerFactory> webServerFactoryCustomizer() {
        WebServerFactoryCustomizer factoryCustomizer = new WebServerFactoryCustomizer() {
            @Override
            public void customize(WebServerFactory factory) {
                //访问端口号
                //factory.setPort(8080);
            }
        };
        return factoryCustomizer;
    }

    /** 配置 区域解析器，实现国际化 */
    @Bean
    public LocaleResolver localeResolver() {
        //通过获取请求连接上携带的区域信息，进行解析
        LocaleResolver localeResolver = new LocaleResolver() {
            @Override
            public Locale resolveLocale(HttpServletRequest httpServletRequest) {
                String language = httpServletRequest.getParameter("l");
                //初始化对象
                Locale locale = Locale.getDefault();
                if (!language.isEmpty()) {
                    String[] split = language.split("_");
                    //0为语言代码；1为国家代码
                    locale = new Locale(split[0],split[1]);
                }
                return locale;
            }
            @Override
            public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {
            }
        };
        return localeResolver;
    }


    /** 配置 模板引擎 */
    //@Bean
    public ITemplateResolver resourceViewResolver() {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setPrefix("classpath:/templates/");
        templateResolver.setSuffix(".html");
        templateResolver.setCacheable(false);
        return templateResolver;
    }

    /** 配置 文件上传属性 */
    //@Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //设置文件上传路径
        //factory.setLocation("d:/upload");
        //factory.setFileSizeThreshold();
        //单个文件最大 KB,MB
        factory.setMaxFileSize(DataSize.ofMegabytes(2));
        //总上传数据大小
        factory.setMaxRequestSize(DataSize.ofMegabytes(10));
        return factory.createMultipartConfig();
    }
}
