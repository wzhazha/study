package org.example.config;

import org.example.interceptor.TokenVerifyInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry
                .addMapping("/**")
                .allowedOrigins("http://localhost:8000")
                .allowedMethods("*")
                .allowCredentials(true)
                .maxAge(3600)
                .allowedHeaders("*");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry
            .addInterceptor(handleTokenVerifyInterceptor())
            .addPathPatterns("/**")
            .excludePathPatterns("/admin/login");
    }

    @Bean
    public TokenVerifyInterceptor handleTokenVerifyInterceptor() {
        return new TokenVerifyInterceptor();
    }
}
