package com.unilever.api.unileverheartbeatapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@Configuration
public class UnileverHeartBeatApiApplication extends SpringBootServletInitializer implements WebApplicationInitializer {

    // Tell Spring to launch our app!
    public static void main(String[] args) {
        SpringApplication.run(UnileverHeartBeatApiApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(UnileverHeartBeatApiApplication.class);
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
