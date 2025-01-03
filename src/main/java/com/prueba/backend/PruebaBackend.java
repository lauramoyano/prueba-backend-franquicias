package com.prueba.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@SpringBootApplication
@ComponentScan(basePackages = "com.prueba.backend")  // Asegúrate de que el paquete correcto esté escaneado
public class PruebaBackend {
    public static void main(String[] args) {
        SpringApplication.run(PruebaBackend.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/*").allowedOrigins("");
            }
        };
    }

    public static final String USE_CASE_ROUTE = "com.prueba.backend.*.domain.useCases";
    public static final String SERVICE_ROUTE = "com.prueba.backend.*.application.handler.impl";
    public static final String ADAPTER_ROUTE = "com.prueba.backend.*.infrastructure.adapters";
}