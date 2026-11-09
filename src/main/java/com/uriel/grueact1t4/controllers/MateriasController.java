
package com.uriel.grueact1t4.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MateriasController {

    @GetMapping("/materias")
    public List<String> materias() {
        return List.of(
            "Programacion Web",
            "Administracion de Redes",
            "Automatas II",
            "Sistemas Programables"
        );
    }
}
