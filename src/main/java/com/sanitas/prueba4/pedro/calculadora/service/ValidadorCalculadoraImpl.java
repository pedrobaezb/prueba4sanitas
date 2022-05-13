package com.sanitas.prueba4.pedro.calculadora.service;

import org.springframework.stereotype.Service;

@Service
public class ValidadorCalculadoraImpl implements ValidadorCalculadora{
    @Override
    public boolean validaSuma(Terminos terminos) {
        return false;
    }

    @Override
    public boolean validaResta(Terminos terminos) {
        return false;
    }
}
