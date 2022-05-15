package com.sanitas.prueba4.pedro.calculadora.service;

import io.corp.calculator.TracerImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Objects;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;
import static org.mockito.Mockito.*;

class CalculadoraControllerTest {
    @Mock
    Calculadora calculadora;
    @Mock
    ValidadorCalculadora validadorCalculadora;
    @Mock
    TracerImpl tracer;
    @InjectMocks
    CalculadoraController calculadoraController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSumaCorrecta() {
        when(calculadora.sumar(any())).thenReturn(new Resultado(new BigDecimal(5.4)));
        when(validadorCalculadora.validaSuma(any())).thenReturn(true);
        tracer.trace(any());

        ResponseEntity<Resultado> result = calculadoraController.suma(new Terminos(Arrays.asList(new BigDecimal(1.1),
                new BigDecimal(2.2))));
        Assertions.assertEquals(200, result.getStatusCodeValue());
        Assertions.assertNotNull(result.getBody().getResultado());
        assertThat(result.getBody().getResultado(), closeTo(new BigDecimal("5.4"), new BigDecimal("0.001")));


    }

    @Test
    void testSumaErronea() {
        when(calculadora.sumar(any())).thenReturn(new Resultado(new BigDecimal(5.4)));
        when(validadorCalculadora.validaSuma(any())).thenReturn(false);
        tracer.trace(any());

        ResponseEntity<Resultado> result = calculadoraController.suma(new Terminos(Arrays.asList(new BigDecimal(1.1),
                new BigDecimal(2.2))));
        Assertions.assertEquals(400, result.getStatusCodeValue());
    }

    @Test
    void testRestaCorrecta() {
        when(calculadora.restar(any())).thenReturn(new Resultado(new BigDecimal(2.3)));
        when(validadorCalculadora.validaResta(any())).thenReturn(true);
        tracer.trace(any());

        ResponseEntity<Resultado> result = calculadoraController.resta(new Terminos(Arrays.asList(new BigDecimal(1.1),
                new BigDecimal(2.2))));
        Assertions.assertEquals(200, result.getStatusCodeValue());
        Assertions.assertNotNull(result.getBody().getResultado());
        assertThat(result.getBody().getResultado(), closeTo(new BigDecimal("2.3"), new BigDecimal("0.001")));
    }

    @Test
    void testRestaErronea() {
        when(calculadora.restar(any())).thenReturn(new Resultado(new BigDecimal(2.3)));
        when(validadorCalculadora.validaResta(any())).thenReturn(false);
        tracer.trace(any());

        ResponseEntity<Resultado> result = calculadoraController.resta(new Terminos(Arrays.asList(new BigDecimal(1.1),
                new BigDecimal(2.2))));
        Assertions.assertEquals(400, result.getStatusCodeValue());
    }
}
