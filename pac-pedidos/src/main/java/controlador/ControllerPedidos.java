package controlador;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerPedidos {
    @GetMapping("/pedidos/saludo")
    public String testPedidos() {
        return "¡Hola desde Pedidos!";
    }
}