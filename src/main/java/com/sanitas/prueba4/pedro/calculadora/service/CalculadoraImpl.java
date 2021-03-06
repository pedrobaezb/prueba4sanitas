package com.sanitas.prueba4.pedro.calculadora.service;

import com.sanitas.prueba4.pedro.calculadora.bean.Terminos;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CalculadoraImpl implements Calculadora {
    public BigDecimal sumar(Terminos terminos) {
        BigDecimal resultado=new BigDecimal(0);
        for (BigDecimal termino: terminos.getTerminos()) {
            resultado=resultado.add(termino);
        }
        return resultado;
    }

    public BigDecimal restar(Terminos terminos) {
        BigDecimal resultado=terminos.getTerminos().get(0);
        for (BigDecimal termino: terminos.getTerminos().subList(1, terminos.getTerminos().size())) {
            resultado=resultado.subtract(termino);
        }
        return resultado;
    }

}
