package com.sanitas.prueba4.pedro.calculadora.service;

import java.math.BigDecimal;
import java.util.List;

public class Terminos {
    private List<BigDecimal> terminos;

    public Terminos() {
    }

    public Terminos(List<BigDecimal> terminos) {
        this.terminos = terminos;
    }

    @Override
    public String toString() {
        return "Terminos{" +
                "terminos=" + terminos +
                '}';
    }

    public List<BigDecimal> getTerminos() {
        return terminos;
    }
}
