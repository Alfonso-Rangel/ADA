package controlador;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerProductos {
    @GetMapping("/productos/saludo")
    public String testProductos() {
        return "¡Hola desde Productos!";
    }
}
