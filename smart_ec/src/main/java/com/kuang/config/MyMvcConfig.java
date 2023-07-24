package com.kuang.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/login.html").setViewName("login");
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/register.html").setViewName("register");
        registry.addViewController("/main.html").setViewName("index");

        registry.addViewController("/login_doc.html").setViewName("index_doc");
    }

    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocalResolver();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/index.html", "/main.html", "/tables.html", "/add.html", "/update.html","/tables_doc","/charts.html","/index_doc.html");
    }
}
