package abstraccion;

import java.util.List;

public class Carrito implements IU_CarritoCompras {
    private List<String> productos;

    public Carrito(List<String> productos) {
        this.productos = productos;
    }

    @Override
    public void comprar() {
        System.out.println("Productos en el carrito:");
        for (String producto : productos) {
            System.out.println("- " + producto);
        }
    }

    public List<String> getProductos() {
        return productos;
    }
}
