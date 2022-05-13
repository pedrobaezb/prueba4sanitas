package com.sanitas.prueba4.pedro.calculadora.service;

public class Resultado {
    private Float resultado;

    public Resultado() {
    }

    public Resultado(Float resultado) {
        this.resultado = resultado;
    }

    @Override
    public String toString() {
        return "Resultado{" +
                "resultado=" + resultado +
                '}';
    }

    public Float getResultado() {
        return resultado;
    }

    public void setResultado(Float resultado) {
        this.resultado = resultado;
    }
}
