package com.lq.SmartWardrobe.config;

import com.lq.SmartWardrobe.interceptor.UserLoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class LoginConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册TestInterceptor拦截器
        InterceptorRegistration registration = registry.addInterceptor(new UserLoginInterceptor());
        //所有路径都被拦截
        registration.addPathPatterns("/**");
        //添加不拦截路径
        registration.excludePathPatterns(
                "/SmartWardrobe/user/login",
                "/SmartWardrobe/user/register",
                "/**/*.html",
                "/**/*.js",
                "/**/*.css",
                "/doc.html"
        );
    }

}
