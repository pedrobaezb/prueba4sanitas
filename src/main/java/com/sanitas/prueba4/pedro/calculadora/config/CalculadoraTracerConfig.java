package com.sanitas.prueba4.pedro.calculadora.config;

import io.corp.calculator.TracerImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CalculadoraTracerConfig {
    @Bean
    public TracerImpl tracerImpl() {
        return new TracerImpl();
    }
}
