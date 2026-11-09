
package com.uriel.grueact1t4.controllers;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProyectoController {

    @GetMapping("/proyecto")
    public String proyecto() {
        return "Proyecto Spring Boot - Uriel Eduardo";
    }

    @GetMapping("/estado")
    public Map<String, String> estado() {
        return Map.of(
            "proyecto", "GRUEact1_t4",
            "estado", "Funcionando",
            "materia", "Programacion Web"
        );
    }
}
