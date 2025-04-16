package controlador;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerUsuarios {
    @GetMapping("/usuarios/saludo")
    public String testUsuarios() {
        return "¡Hola desde Usuarios!";
    }
}

