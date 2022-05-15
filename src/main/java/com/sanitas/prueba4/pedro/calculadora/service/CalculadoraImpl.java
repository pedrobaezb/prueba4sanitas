package com.sanitas.prueba4.pedro.calculadora.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CalculadoraImpl implements Calculadora {
    public Resultado sumar(Terminos terminos) {
        BigDecimal resultado=new BigDecimal(0);
        for (BigDecimal termino: terminos.getTerminos()) {
            resultado=resultado.add(termino);
        }
        return new Resultado(resultado);
    }

    public Resultado restar(Terminos terminos) {
        BigDecimal resultado=terminos.getTerminos().get(0);
        for (BigDecimal termino: terminos.getTerminos().subList(1, terminos.getTerminos().size())) {
            resultado=resultado.subtract(termino);
        }
        return new Resultado(resultado);
    }

}
