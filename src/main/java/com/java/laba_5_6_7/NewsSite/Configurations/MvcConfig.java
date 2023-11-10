package com.java.laba_5_6_7.NewsSite.Configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Добавить обработчик для загруженных файлов
        registry.addResourceHandler("/uploads/**").addResourceLocations("file:uploads/");
    }
}