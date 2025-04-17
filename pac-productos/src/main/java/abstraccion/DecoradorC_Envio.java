package abstraccion;

// DecoradorC_Envio.java
public class DecoradorC_Envio extends Decorador_Carrito {
    private String direccionEnvio;
    private double peso;

    public DecoradorC_Envio(IU_CarritoCompras carrito, String direccionEnvio, double peso) {
        super(carrito);
        this.direccionEnvio = direccionEnvio;
        this.peso = peso;
    }

    public void getDatosEnvio(String direccion, double peso) {
        this.direccionEnvio = direccion;
        this.peso = peso;
    }

    public String getDireccionEnvio() {
        return direccionEnvio;
    }

    @Override
    public void comprar() {
        super.comprar();
        System.out.println("Direccion de envio: " + direccionEnvio);
        System.out.println("Peso total: " + peso + "kg");
    }
}

