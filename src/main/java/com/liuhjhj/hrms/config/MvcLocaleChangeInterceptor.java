package com.liuhjhj.hrms.config;

import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

public class MvcLocaleChangeInterceptor extends LocaleChangeInterceptor {

    public LocaleChangeInterceptor localeChangeInterceptor(){
        //使用LocaleChangeInterceptor永久保存区域信息
        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName("lang");
        return localeChangeInterceptor;
    }
}
