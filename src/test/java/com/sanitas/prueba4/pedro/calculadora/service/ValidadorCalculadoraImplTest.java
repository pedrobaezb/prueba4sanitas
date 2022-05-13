package com.sanitas.prueba4.pedro.calculadora.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

class ValidadorCalculadoraImplTest {
    ValidadorCalculadoraImpl validadorCalculadoraImpl = new ValidadorCalculadoraImpl();

    @Test
    void testValidaSumaNula() {
        boolean result = validadorCalculadoraImpl.validaSuma(new Terminos());
        Assertions.assertEquals(false, result);
    }

    @Test
    void testValidaSumaVacia() {
        boolean result = validadorCalculadoraImpl.validaSuma(new Terminos(new ArrayList<Float>()));
        Assertions.assertEquals(false, result);
    }

    @Test
    void testValidaSumaSoloUnTermino() {
        boolean result = validadorCalculadoraImpl.validaSuma(new Terminos(Arrays.asList(1.1f)));
        Assertions.assertEquals(false, result);
    }

    @Test
    void testValidaSumaDemasiadosTerminos() {
        boolean result = validadorCalculadoraImpl.validaSuma(new Terminos(Arrays.asList(1.1f,2.2f,3.3f)));
        Assertions.assertEquals(false, result);
    }

    @Test
    void testValidaSumaCorrecta() {
        boolean result = validadorCalculadoraImpl.validaSuma(new Terminos(Arrays.asList(1.1f,2.2f)));
        Assertions.assertEquals(true, result);
    }

    @Test
    void testValidaRestaNula() {
        boolean result = validadorCalculadoraImpl.validaResta(new Terminos());
        Assertions.assertEquals(false, result);
    }

    @Test
    void testValidaRestaVacia() {
        boolean result = validadorCalculadoraImpl.validaResta(new Terminos(new ArrayList<Float>()));
        Assertions.assertEquals(false, result);
    }

    @Test
    void testValidarestaSoloUnTermino() {
        boolean result = validadorCalculadoraImpl.validaResta(new Terminos(Arrays.asList(1.1f)));
        Assertions.assertEquals(false, result);
    }

    @Test
    void testValidaRestaDemasiadosTerminos() {
        boolean result = validadorCalculadoraImpl.validaResta(new Terminos(Arrays.asList(1.1f,2.2f,3.3f)));
        Assertions.assertEquals(false, result);
    }

    @Test
    void testValidaRestaCorrecta() {
        boolean result = validadorCalculadoraImpl.validaResta(new Terminos(Arrays.asList(1.1f,2.2f)));
        Assertions.assertEquals(true, result);
    }
}
