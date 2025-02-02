package com.bamdoliro.teampage.global.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class corsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000", "https://bamdoliro.com", "https://teampage.bamdoliro.com", "https://teampage-gamma.vercel.app", "http://bamdoliro.kro.kr", "https://bamdoliro.kro.kr")
                .allowedMethods("*");
    }
}
