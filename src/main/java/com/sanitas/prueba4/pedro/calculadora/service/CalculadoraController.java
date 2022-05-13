package com.sanitas.prueba4.pedro.calculadora.service;

import com.sanitas.prueba4.pedro.calculadora.utils.CalculadoraTracer;
import io.corp.calculator.TracerAPI;
import io.corp.calculator.TracerImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculadora")
public class CalculadoraController {
    private static Logger log = LoggerFactory.getLogger(CalculadoraController.class);
    private static TracerAPI tracer;

    private Calculadora calculadora;

    private ValidadorCalculadora validadorCalculadora;


    @Autowired
    public CalculadoraController(Calculadora calculadora, ValidadorCalculadora validadorCalculadora, TracerAPI tracer) {
        this.calculadora=calculadora;
        this.validadorCalculadora=validadorCalculadora;
        this.tracer=tracer;
    }

    @PostMapping("/suma")
    public ResponseEntity<Resultado> suma(@RequestBody Terminos terminos) {
        log.debug("Terminos recibidos {}", terminos);
        boolean esValido=validadorCalculadora.validaSuma(terminos);
        if(esValido) {
            Resultado resultado=calculadora.sumar(terminos);
            log.debug("Resultado {}",resultado);
            tracer.trace(resultado);
            return ResponseEntity.ok(resultado);
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/resta")
    public ResponseEntity<Resultado> resta(@RequestBody Terminos terminos) {
        log.debug("Terminos recibidos {}", terminos);
        boolean esValido=validadorCalculadora.validaResta(terminos);
        if(esValido) {
            Resultado resultado=calculadora.restar(terminos);
            log.debug("Resultado {}",resultado);
            tracer.trace(resultado);
            return ResponseEntity.ok(resultado);
        }
        return ResponseEntity.badRequest().build();
    }
}
