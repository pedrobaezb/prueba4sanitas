package com.sanitas.prueba4.pedro.calculadora.service;

import java.util.List;

public class Terminos {
    private List<Float> terminos;

    public Terminos() {
    }

    public Terminos(List<Float> terminos) {
        this.terminos = terminos;
    }

    @Override
    public String toString() {
        return "Terminos{" +
                "terminos=" + terminos +
                '}';
    }

    public List<Float> getTerminos() {
        return terminos;
    }

    public void setTerminos(List<Float> terminos) {
        this.terminos = terminos;
    }
}
