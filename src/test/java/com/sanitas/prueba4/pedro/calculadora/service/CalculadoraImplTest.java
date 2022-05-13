package com.sanitas.prueba4.pedro.calculadora.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class CalculadoraImplTest {
    CalculadoraImpl calculadoraImpl = new CalculadoraImpl();

    @Test
    void testSumar() {
        Resultado result = calculadoraImpl.sumar(new Terminos(Arrays.asList(1.1f,2.2f)));
        Assertions.assertEquals(3.3f, result.getResultado(), 0.0001f);
    }

    @Test
    void testRestar() {
        Resultado result = calculadoraImpl.restar(new Terminos(Arrays.asList(4.0f,2.0f)));
        Assertions.assertEquals(2f, result.getResultado(), 0.0001f);
    }

}
