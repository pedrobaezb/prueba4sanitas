package com.sanitas.prueba4.pedro.calculadora.healthService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
public class HealthController {
    @GetMapping
    public ResponseEntity<HealthCheckResponse> probarSaludServicio() {
        return ResponseEntity.ok(new HealthCheckResponse());
    }
}
