
package com.uriel.grueact1t4.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.uriel.grueact1t4.dto.ProductoDTO;

@RestController
public class ProductoRestController {

    @PostMapping("/api/productos")
    public ProductoDTO recibirProducto(@RequestBody ProductoDTO producto) {
        return producto;
    }
}
