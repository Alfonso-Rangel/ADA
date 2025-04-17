package abstraccion;

public class Pago {
    private IUPago metodoPago;

    // El objeto Pago recibe una implementación de IUPago (puede ser proxy o real)
    public Pago(IUPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    // Método para realizar el pago
    public ComprobantePago realizarPago(float monto) {
        return metodoPago.MetodoDePago(monto);
    }
}
