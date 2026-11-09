
package com.uriel.grueact1t4.controllers;

import com.uriel.grueact1t4.dto.ProductoDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductosController {

    @Value("${app.nombre}")
    private String nombreProyecto;

    private final List<ProductoDTO> productos = new ArrayList<>(List.of(
        new ProductoDTO(1, "Cuaderno", "Papeleria", 45.0),
        new ProductoDTO(2, "Memoria USB", "Tecnologia", 120.0),
        new ProductoDTO(3, "Lapiz", "Papeleria", 8.0)
    ));

    // Mostrar productos y filtrar por categoria
    @GetMapping("/productos")
    public String listar(
            @RequestParam(required = false) String categoria,
            Model model) {

        List<ProductoDTO> lista = productos;

        if (categoria != null && !categoria.isBlank()) {
            lista = productos.stream()
                .filter(p -> p.getCategoria().equalsIgnoreCase(categoria))
                .toList();
        }

        model.addAttribute("productos", lista);
        model.addAttribute("categoria", categoria);
        model.addAttribute("nombreProyecto", nombreProyecto);

        return "productos";
    }

    // Mostrar formulario
    @GetMapping("/productos/nuevo")
    public String formulario(Model model) {
        model.addAttribute("producto", new ProductoDTO());
        return "formulario";
    }

    // Recibir los datos del formulario
    @PostMapping("/productos/guardar")
    public String guardar(@ModelAttribute ProductoDTO producto) {

        int nuevoId = productos.stream()
            .mapToInt(ProductoDTO::getId)
            .max()
            .orElse(0) + 1;

        producto.setId(nuevoId);
        productos.add(producto);

        return "redirect:/productos";
    }

    // Consultar un producto por su ID
    @GetMapping("/productos/{id}")
    public String detalle(@PathVariable Integer id, Model model) {

        for (ProductoDTO producto : productos) {
            if (producto.getId().equals(id)) {
                model.addAttribute("producto", producto);
                return "detalle";
            }
        }

        return "redirect:/productos";
    }
}
