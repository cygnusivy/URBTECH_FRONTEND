package com.urbtech.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/usuario/**")
                        .allowedOrigins("https://urbtech.netlify.app")
                        .allowedMethods("GET", "POST", "PUT", "DELETE");

                registry.addMapping("/login/**")
                        .allowedOrigins("https://urbtech.netlify.app")
                        .allowedMethods("GET", "POST", "PUT", "DELETE");

                registry.addMapping("/post/**")
                        .allowedOrigins("https://urbtech.netlify.app")
                        .allowedMethods("GET", "POST", "PUT", "DELETE");

                registry.addMapping("/comunidade/**")
                        .allowedOrigins("https://urbtech.netlify.app")
                        .allowedMethods("GET", "POST", "PUT", "DELETE");

                registry.addMapping("/comentario/**")
                        .allowedOrigins("https://urbtech.netlify.app")
                        .allowedMethods("GET", "POST", "PUT", "DELETE");
            }
        };
    }
}