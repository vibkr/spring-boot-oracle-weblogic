package com.unilever.api.unileverheartbeatapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class UnileverHeartbeatApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(UnileverHeartbeatApiApplication.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD","OPTIONS")
                        .allowedOrigins("http://localhost:8000","http://localhost:8001","http://localhost:8081","http://localhost:7001","https://adfunlvtestpub.oracleoutsourcing.com","https://adfunlvprodpub.oracleoutsourcing.com");
            }
        };
    }
}
