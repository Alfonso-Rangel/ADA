package controlador;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/compras")
public class ControllerCompras {

    // ========== Ejemplo de cómo recibir datos en formato json desde el frontend ===========
    // DTO muy simple para mapear el JSON de entrada
    public record EjemploObjeto(
        String atributo1, 
        String atributo2
    ) {}

    /**
     * POST - Recibe un objeto como JSON
     * Ejemplo body: {"atributo1": "mail@cua.uam", "atributo2": "mypassword"}
     */
    @PostMapping("/test") // Desde el frontend se usa la ruta http://localhost:8080/compras/test para usar este método
    public String test(@RequestBody EjemploObjeto json) {
        // Aquí pueden usar el objeto json como quieran, por ejemplo, guardarlo en una base de datos o procesarlo en la capa de abstracción
        return String.format("Recibido: %s | %s", json.atributo1, json.atributo2); // No es necesario devolver un mensaje.
    }
    // En resources/static/test-compras.html pueden encontrar un ejemplo de cómo enviar el JSON desde el frontend usando JavaScript.

    // ===================Pueden borrar este ejemplo si no lo necesitan======================

}