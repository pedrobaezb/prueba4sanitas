package com.sanitas.prueba4.pedro.calculadora.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;

import static org.mockito.Mockito.*;

class CalculadoraControllerTest {
    @Mock
    Calculadora calculadora;
    @Mock
    ValidadorCalculadora validadorCalculadora;
    @InjectMocks
    CalculadoraController calculadoraController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSumaCorrecta() {
        when(calculadora.sumar(any())).thenReturn(new Resultado(Float.valueOf(5.4f)));
        when(validadorCalculadora.validaSuma(any())).thenReturn(true);

        ResponseEntity<Resultado> result = calculadoraController.suma(new Terminos(Arrays.asList(1.1f,2.2f)));
        Assertions.assertEquals(200, result.getStatusCodeValue());
        Assertions.assertEquals(5.4f, result.getBody().getResultado());
    }

    @Test
    void testSumaErronea() {
        when(calculadora.sumar(any())).thenReturn(new Resultado(Float.valueOf(5.4f)));
        when(validadorCalculadora.validaSuma(any())).thenReturn(false);

        ResponseEntity<Resultado> result = calculadoraController.suma(new Terminos(Arrays.asList(1.1f,2.2f)));
        Assertions.assertEquals(400, result.getStatusCodeValue());
    }

    @Test
    void testRestaCorrecta() {
        when(calculadora.restar(any())).thenReturn(new Resultado(Float.valueOf(2.3f)));
        when(validadorCalculadora.validaResta(any())).thenReturn(true);

        ResponseEntity<Resultado> result = calculadoraController.resta(new Terminos(Arrays.asList(1.1f,2.2f)));
        Assertions.assertEquals(200, result.getStatusCodeValue());
        Assertions.assertEquals(2.3f, result.getBody().getResultado());
    }

    @Test
    void testRestaErronea() {
        when(calculadora.restar(any())).thenReturn(new Resultado(Float.valueOf(2.3f)));
        when(validadorCalculadora.validaResta(any())).thenReturn(false);

        ResponseEntity<Resultado> result = calculadoraController.resta(new Terminos(Arrays.asList(1.1f,2.2f)));
        Assertions.assertEquals(400, result.getStatusCodeValue());
    }
}
