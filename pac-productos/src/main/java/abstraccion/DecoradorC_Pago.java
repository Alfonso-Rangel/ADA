package abstraccion;

// DecoradorC_Pago.java
public class DecoradorC_Pago extends Decorador_Carrito {
    private final double monto;
    private final String metodoPago;

    public DecoradorC_Pago(IU_CarritoCompras carrito, double monto, String metodoPago) {
        super(carrito);
        this.monto = monto;
        this.metodoPago = metodoPago;
    }

    public void calcularTotal() {
        System.out.println("Monto total a pagar: $" + monto);
    }

    public void Paypal() {
        System.out.println("Pago realizado vía PayPal");
    }

    public void PTarjeta() {
        System.out.println("Pago realizado con tarjeta");
    }

    @Override
    public void comprar() {
        super.comprar();
        calcularTotal();
        if ("paypal".equalsIgnoreCase(metodoPago)) {
            Paypal();
        } else {
            PTarjeta();
        }
    }
}
