package abstraccion;

public class PagoReal implements IUPago {
    private String usuario;

    // Constructor que recibe el nombre del usuario
    public PagoReal(String usuario) {
        this.usuario = usuario;
    }

    @Override
    public ComprobantePago MetodoDePago(float monto) {
        // Este método solo se llama si el Proxy ya validó que el pago es posible
        return new ComprobantePago(monto, "Éxito", "Pago realizado con éxito por " + usuario + ".");
    }
}


