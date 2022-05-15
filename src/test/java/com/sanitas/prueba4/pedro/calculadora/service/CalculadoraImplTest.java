package com.sanitas.prueba4.pedro.calculadora.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;

class CalculadoraImplTest {
    final CalculadoraImpl calculadoraImpl = new CalculadoraImpl();

    @Test
    void testSumar() {
        Resultado result = calculadoraImpl.sumar(new Terminos(Arrays.asList(new BigDecimal(1.1),
                new BigDecimal(2.2))));
        assertThat(result.getResultado(), closeTo(new BigDecimal("3.3"), new BigDecimal("0.001")));
    }

    @Test
    void testRestar() {
        Resultado result = calculadoraImpl.restar(new Terminos(Arrays.asList(new BigDecimal(4.0),
                new BigDecimal(2.0))));
        assertThat(result.getResultado(), closeTo(new BigDecimal("2"), new BigDecimal("0.001")));
    }

}
