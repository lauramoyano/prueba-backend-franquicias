package com.prueba.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class PruebaBackend {
    public static void main(String[] args) {

        SpringApplication.run(PruebaBackend.class, args);
    }


    public static final String USE_CASE_ROUTE = "com.prueba.backend.domain.useCases";
    public static final String SERVICE_ROUTE = "com.prueba.backend.application.handler.impl";
    public static final String ADAPTER_ROUTE = "com.prueba.backend.infrastructure.adapters";
    public static final String MAPPER_ROUTE = "com.prueba.backend.infrastructure.mappers";

}