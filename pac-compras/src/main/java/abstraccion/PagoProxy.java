package abstraccion;

import java.util.Random;

public class PagoProxy implements IUPago {
    private PagoReal pagoReal;
    private String usuario;

    // El proxy necesita saber quién es el usuario
    public PagoProxy(String usuario) {
        this.usuario = usuario;
        this.pagoReal = new PagoReal(usuario);  // Composición con el objeto real
    }

    @Override
    public ComprobantePago MetodoDePago(float monto) {
        // Primera validación: monto mayor que 0
        if (monto <= 0) {
            return new ComprobantePago(monto, "Fallido", "Monto inválido. Pago rechazado.");
        }

        // Segunda validación: simular fallo aleatorio (20% de probabilidad)
        boolean exito = new Random().nextDouble() > 0.2;

        if (!exito) {
            return new ComprobantePago(monto, "Fallido", "Error inesperado. Pago rechazado.");
        }

        // Si todo pasa, se delega al objeto real
        return pagoReal.MetodoDePago(monto);
    }
}
