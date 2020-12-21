package com.liuhjhj.hrms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/index.html").setViewName("login");
        registry.addViewController("/index").setViewName("login");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //拦截器要对静态资源放行,否则css样式无法加载
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/","/index","/index.html","/asserts/**","/webjars/**")
                .excludePathPatterns("/login");
        MvcLocaleChangeInterceptor mvcLocaleChangeInterceptor = new MvcLocaleChangeInterceptor();
        registry.addInterceptor(mvcLocaleChangeInterceptor.localeChangeInterceptor());
    }

    @Bean
    public LocaleResolver localeResolver(){
        SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
        sessionLocaleResolver.setDefaultLocale(Locale.getDefault());
        return sessionLocaleResolver;
    }
}
