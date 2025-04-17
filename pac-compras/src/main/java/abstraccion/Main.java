package abstraccion;

public class Main {
    public static void main(String[] args) {
        // Simula el primer caso: pago exitoso
        System.out.println("=== Caso 1: Pago exitoso ===");
        ejecutarPago("Mauricio", 500f);  // monto válido

        // Simula el segundo caso: pago fallido por monto inválido
        System.out.println("\n=== Caso 2: Pago fallido (monto inválido) ===");
        ejecutarPago("Iván", 0f);  // monto inválido
    }

    // Método auxiliar para ejecutar el pago y mostrar el comprobante
    private static void ejecutarPago(String usuario, float monto) {
        // Se crea el proxy con el nombre del usuario
        IUPago proxy = new PagoProxy(usuario);

        // Se pasa el proxy al objeto Pago
        Pago pago = new Pago(proxy);

        // El gestor (controlador) se encarga de hacer la solicitud
        GestordeCompras gestor = new GestordeCompras(pago);

        // Se realiza el pago y se obtiene el comprobante
        ComprobantePago comprobante = gestor.solicitarPago(monto);

        // Se imprime el resultado del comprobante
        System.out.println(comprobante);
    }
}

