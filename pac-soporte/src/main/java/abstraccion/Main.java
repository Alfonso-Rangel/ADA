package abstraccion;

public class Main {
    public static void main(String[] args) {

        APIEmail apiEmail = new APIEmail();

        EmailAdapter adapter = new EmailAdapter(apiEmail, "sistema@empresa.com", "api-key-12345");

        Mensajeria mensajeria = new Mensajeria(adapter);


        System.out.println("=== Probando envío de email exitoso ===");
        Mensaje mensajeExitoso = new Mensaje(
                "remitente@ejemplo.com",
                "cliente@ejemplo.com",
                "Información solicitada",
                "Aquí está la información que solicitó."
        );
        boolean resultadoExitoso = mensajeria.enviarCorreo(mensajeExitoso);
        System.out.println("Resultado: " + (resultadoExitoso ? "Envío exitoso" : "Envío fallido"));


        System.out.println("\n=== Probando envío de email con autorización denegada ===");
        Mensaje mensajeBloqueado = new Mensaje(
                "remitente@ejemplo.com",
                "blocked@example.com",
                "Información solicitada",
                "Este mensaje no debería enviarse."
        );
        boolean resultadoBloqueado = mensajeria.enviarCorreo(mensajeBloqueado);
        System.out.println("Resultado: " + (resultadoBloqueado ? "Envío exitoso" : "Envío fallido"));
    }

}