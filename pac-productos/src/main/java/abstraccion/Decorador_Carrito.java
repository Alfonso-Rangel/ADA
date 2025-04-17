package abstraccion;

public abstract class Decorador_Carrito implements IU_CarritoCompras {
    protected IU_CarritoCompras carrito;

    public Decorador_Carrito(IU_CarritoCompras carrito) {
        this.carrito = carrito;
    }

    @Override
    public void comprar() {
        carrito.comprar();
    }
}
