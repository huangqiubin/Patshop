package com.hqb.patshop.config.resource;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 自定义图片资源访问路径
 */
@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 将/static/**访问映射到classpath:/img/
        registry.addResourceHandler("/img/**").addResourceLocations("classpath:/static/");
    }
}
