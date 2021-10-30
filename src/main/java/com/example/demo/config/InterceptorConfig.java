package com.example.demo.config;

import com.example.demo.interceptor.HelloInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // /** 匹配所有   /aDimer/** 匹配aDimer 下所有    /aDimer/* 匹配aDimer 下一级所有

        registry.addInterceptor(new HelloInterceptor()).addPathPatterns("/**");
    }
}
