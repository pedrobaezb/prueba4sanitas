package com.sanitas.prueba4.pedro.calculadora.service;


import com.sanitas.prueba4.pedro.calculadora.bean.Terminos;

import java.math.BigDecimal;

public interface Calculadora {
    BigDecimal sumar(Terminos terminos);
    BigDecimal restar(Terminos terminos);
}
