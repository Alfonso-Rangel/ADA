package abstraccion;
// GestorDeProductos.java
import java.util.Arrays;

public class GestorDeProductos {
    public static void main(String[] args) {
        // Crear carrito base
        Carrito carritoBase = new Carrito(Arrays.asList("Tenis deportivos", "Blusa de encaje", "Gorra de mezclilla", "Collar de plata"));

        // Decorar con datos de envío
        DecoradorC_Envio envio = new DecoradorC_Envio(carritoBase, "Vasco de Quiroga 4871, Contadero Cuajimalpa", 3.5);

        // Decorar con pago
        DecoradorC_Pago pago = new DecoradorC_Pago(envio, 8200.0, "tarjeta");

        // Realizar compra final
        pago.comprar();
    }
}
