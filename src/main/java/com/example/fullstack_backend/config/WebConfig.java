package com.example.fullstack_backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/**")
                        .allowedOrigins("https://spring-boot-example-flame.vercel.app", "https://springboot-example-backend-production.up.railway.app")
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")  // Allow preflight OPTIONS method
                        .allowedHeaders("Content-Type", "Authorization", "X-Requested-With", "Accept", "Origin")
                        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials")
                        .allowCredentials(true)
                        .maxAge(3600);  // Cache preflight response for 1 hour
            }
        };
    }
}
