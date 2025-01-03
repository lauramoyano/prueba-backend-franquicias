package com.prueba.backend.infraestructure.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;



@Configuration
@Import(BeanConfig.class)
public class BeanConfiguration {


}
