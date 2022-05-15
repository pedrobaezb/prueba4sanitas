package com.sanitas.prueba4.pedro.calculadora.controller;

import com.sanitas.prueba4.pedro.calculadora.service.Calculadora;
import com.sanitas.prueba4.pedro.calculadora.bean.Terminos;
import com.sanitas.prueba4.pedro.calculadora.validator.ValidadorCalculadora;
import io.corp.calculator.TracerImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/calculadora")
public class CalculadoraController {
    private static final Logger log = LoggerFactory.getLogger(CalculadoraController.class);
    private final TracerImpl tracer;

    private final Calculadora calculadora;

    private final ValidadorCalculadora validadorCalculadora;


    @Autowired
    public CalculadoraController(Calculadora calculadora, ValidadorCalculadora validadorCalculadora, TracerImpl tracer) {
        this.calculadora=calculadora;
        this.validadorCalculadora=validadorCalculadora;
        this.tracer=tracer;
    }

    @PostMapping("/suma")
    public ResponseEntity<BigDecimal> suma(@RequestBody Terminos terminos) {
        try {
            log.debug("Terminos recibidos {}", terminos);
            boolean esValido = validadorCalculadora.validaSuma(terminos);
            if (esValido) {
                BigDecimal resultado = calculadora.sumar(terminos);
                log.debug("Resultado {}", resultado);
                tracer.trace(resultado);
                return ResponseEntity.ok(resultado);
            }
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            log.error("Error general en la operacion suma",e);
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/resta")
    public ResponseEntity<BigDecimal> resta(@RequestBody Terminos terminos) {
        try {
            log.debug("Terminos recibidos {}", terminos);
            boolean esValido=validadorCalculadora.validaResta(terminos);
            if(esValido) {
                BigDecimal resultado=calculadora.restar(terminos);
                log.debug("Resultado {}",resultado);
                tracer.trace(resultado);
                return ResponseEntity.ok(resultado);
            }
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            log.error("Error general en la operacion resta",e);
            return ResponseEntity.internalServerError().build();
        }
    }
}
