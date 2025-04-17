package abstraccion;

import java.math.BigDecimal;

public class Producto {
    private final String nombre;
    private final BigDecimal precio;

    public Producto(String nombre, BigDecimal precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public Object getNombre() {
        return nombre;
    }
}