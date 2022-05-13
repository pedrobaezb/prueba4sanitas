package com.sanitas.prueba4.pedro.calculadora.service;

import org.springframework.stereotype.Service;

@Service
public class ValidadorCalculadoraImpl implements ValidadorCalculadora{
    @Override
    public boolean validaSuma(Terminos terminos) {
        return validaTerminos(terminos);
    }

    @Override
    public boolean validaResta(Terminos terminos) {
        return validaTerminos(terminos);
    }

    private boolean validaTerminos(Terminos terminos) {
        if(terminos==null)
            return false;
        if(terminos.getTerminos()==null)
            return false;

        return terminos.getTerminos().size() == 2;
    }
}
