package com.sanitas.prueba4.pedro.calculadora.service;

import java.math.BigDecimal;

public class Resultado {
    private final BigDecimal resultado;

    public Resultado(BigDecimal resultado) {
        this.resultado = resultado;
    }

    @Override
    public String toString() {
        return "Resultado{" +
                "resultado=" + resultado +
                '}';
    }

    public BigDecimal getResultado() {
        return resultado;
    }
}
