package com.sanitas.prueba4.pedro.calculadora.service;

import org.springframework.stereotype.Service;

@Service
public class CalculadoraImpl implements Calculadora {
    public Resultado sumar(Terminos terminos) {
        Float resultado=0f;
        for (Float termino: terminos.getTerminos()) {
            resultado+=termino;
        }
        return new Resultado(resultado);
    }

    public Resultado restar(Terminos terminos) {
        Float resultado=terminos.getTerminos().get(0);
        for (Float termino: terminos.getTerminos().subList(1, terminos.getTerminos().size())) {
            resultado-=termino;
        }
        return new Resultado(resultado);
    }

}
