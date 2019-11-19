package com.ranjun1999.personalutils.config;


import com.ranjun1999.personalutils.interceptor.ResponseInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author: ranjun
 * @Date: 2019/5/30 15:06
 */

/**
 * 注册拦截器
 */
@Configuration
public class MyAdapter implements WebMvcConfigurer {


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new ResponseInterceptor()).addPathPatterns("/**");
    }
}
