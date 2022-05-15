package com.sanitas.prueba4.pedro.calculadora.service;


import java.math.BigDecimal;

public interface Calculadora {
    BigDecimal sumar(Terminos terminos);
    BigDecimal restar(Terminos terminos);
}
