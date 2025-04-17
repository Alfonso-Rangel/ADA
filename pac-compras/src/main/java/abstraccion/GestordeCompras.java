package abstraccion;

public class GestordeCompras {
    private Pago pago;

    public GestordeCompras(Pago pago) {
        this.pago = pago;
    }

    // Método que simula la solicitud de pago
    public ComprobantePago solicitarPago(float monto) {
        return pago.realizarPago(monto);
    }
}
