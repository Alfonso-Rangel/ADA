package abstraccion;

import java.math.BigDecimal;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Producto> productos = List.of(
                new Producto("Sudadera", new BigDecimal("799.99")),
                new Producto("Reloj", new BigDecimal("1399.99")),
                new Producto("Pantalones", new BigDecimal("599.99")),
                new Producto("Tenis", new BigDecimal("899.99"))
        );
    
        System.out.println("\n[CLIENTE] Creando nuevo pedido");
        Pedido pedido = new Pedido(productos);
    
        System.out.println("\n[CLIENTE] Procesando pedido...");
        String factura = pedido.procesarPedido();
        System.out.println("\n" + factura);
    
        System.out.println("\n[CLIENTE] Consultar estado actual del pedido:");
        System.out.println(pedido.infoPedido());
    
        System.out.println("\n[CLIENTE] Solicitando devolución...");
        String motivo = "Producto en mal estado";
        pedido.iniciarDevolucion(motivo);
    
        System.out.println("\n[CLIENTE] Estado después de devolución:");
        System.out.println(pedido.infoPedido());
    }
}