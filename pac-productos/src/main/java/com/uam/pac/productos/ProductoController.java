package com.uam.pac.productos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductoController {
    @GetMapping("/api/productos/saludo")
    public String saludo() {
        return "Hola desde el PAC Productos!";
    }
}
