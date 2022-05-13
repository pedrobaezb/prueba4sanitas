package com.sanitas.prueba4.pedro.calculadora.service;

import io.corp.calculator.TracerAPI;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.Objects;

import static org.mockito.Mockito.*;

class CalculadoraControllerTest {
    @Mock
    Calculadora calculadora;
    @Mock
    ValidadorCalculadora validadorCalculadora;
    @Mock
    TracerAPI tracerAPI;
    @InjectMocks
    CalculadoraController calculadoraController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSumaCorrecta() {
        when(calculadora.sumar(any())).thenReturn(new Resultado(5.4f));
        when(validadorCalculadora.validaSuma(any())).thenReturn(true);
        tracerAPI.trace(any());

        ResponseEntity<Resultado> result = calculadoraController.suma(new Terminos(Arrays.asList(1.1f,2.2f)));
        Assertions.assertEquals(200, result.getStatusCodeValue());
        Assertions.assertNotNull(result.getBody().getResultado());
        Assertions.assertEquals(5.4f, Objects.requireNonNull(result.getBody().getResultado()));
    }

    @Test
    void testSumaErronea() {
        when(calculadora.sumar(any())).thenReturn(new Resultado(5.4f));
        when(validadorCalculadora.validaSuma(any())).thenReturn(false);
        tracerAPI.trace(any());

        ResponseEntity<Resultado> result = calculadoraController.suma(new Terminos(Arrays.asList(1.1f,2.2f)));
        Assertions.assertEquals(400, result.getStatusCodeValue());
    }

    @Test
    void testRestaCorrecta() {
        when(calculadora.restar(any())).thenReturn(new Resultado(2.3f));
        when(validadorCalculadora.validaResta(any())).thenReturn(true);
        tracerAPI.trace(any());

        ResponseEntity<Resultado> result = calculadoraController.resta(new Terminos(Arrays.asList(1.1f,2.2f)));
        Assertions.assertEquals(200, result.getStatusCodeValue());
        Assertions.assertNotNull(result.getBody().getResultado());
        Assertions.assertEquals(2.3f, Objects.requireNonNull(result.getBody().getResultado()));
    }

    @Test
    void testRestaErronea() {
        when(calculadora.restar(any())).thenReturn(new Resultado(2.3f));
        when(validadorCalculadora.validaResta(any())).thenReturn(false);
        tracerAPI.trace(any());

        ResponseEntity<Resultado> result = calculadoraController.resta(new Terminos(Arrays.asList(1.1f,2.2f)));
        Assertions.assertEquals(400, result.getStatusCodeValue());
    }
}
