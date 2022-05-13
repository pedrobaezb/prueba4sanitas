package com.sanitas.prueba4.pedro.calculadora.service;

import java.util.ArrayList;

public class Terminos {
    private ArrayList<Float> terminos;

    public Terminos() {
    }

    public Terminos(ArrayList<Float> terminos) {
        this.terminos = terminos;
    }

    @Override
    public String toString() {
        return "Terminos{" +
                "terminos=" + terminos +
                '}';
    }

    public ArrayList<Float> getTerminos() {
        return terminos;
    }

    public void setTerminos(ArrayList<Float> terminos) {
        this.terminos = terminos;
    }
}
