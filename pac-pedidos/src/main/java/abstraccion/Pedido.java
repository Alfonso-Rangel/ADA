package abstraccion;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Pedido {
    private final String id;
    private final List<Producto> productos;
    private final DatosEnvio datosEnvio;
    private final SeguimientoEnvio seguimiento;
    private final Pago pago;
    private Paqueteria paqueteria;
    private Devolucion devolucion;
    private LocalDate fechaEntrega;

    public Pedido(List<Producto> productos) {
        this.id = "PED-1";
        this.productos = productos;

        // Creación de partes controlada por el Todo
        this.datosEnvio = new DatosEnvio();
        this.pago = new Pago();
        this.seguimiento = new SeguimientoEnvio();

        Log.log("Pedido", "Pedido " + id + " creado con " + productos.size() + " productos");
    }

    public String procesarPedido() {
        try {
            Log.log("Pedido", "Iniciando procesamiento del pedido " + id);

            //1. Ingresar datos de envio
            datosEnvio.obtenerDireccion();

            // 2. Seleccionar empresa Transportista
            AbstraccionTransportista transportista = Math.random() < 0.5 ?
                    new ImplementacionFedEx() :
                    new ImplementacionDHL();

            // 3. Seleccionar tipo de envio
            double rand = Math.random();
            AbstraccionTipoEnvio tipoEnvio =
                    rand > 0.66 ? new ImplementacionNacional() :
                    rand > 0.33 ? new ImplementacionInternacional() :
                                  new ImplementacionExpress();


            paqueteria = new Paqueteria(transportista, tipoEnvio);

            // 4. Calcula tarifa de envío
            BigDecimal tarifa = paqueteria.calcularTarifa(
                    datosEnvio.getDireccion(),
                    productos
            );

            // 5. Calcula fecha de entrega
            fechaEntrega = paqueteria.calcularFechaEntrega(datosEnvio.getDireccion());

            // 6. Procesar pago
            String factura = pago.procesarPago(
                    calcularTotalProductos().add(tarifa),
                    productos
            );

            // 7. Actualizar seguimiento
            seguimiento.actualizarEstado();

            Log.log("Pedido", "Pedido " + id + " procesado exitosamente");
            return factura;

        } catch (Exception e) {
            Log.log("Pedido", "Error en pedido " + id + ": " + e.getMessage());
            cancelarTodo();
            return "Error: " + e.getMessage();
        }
    }

    private void cancelarTodo() {
        Log.log("Pedido", "Cancelando componentes del pedido " + id);
        seguimiento.cancelarEnvio();
        if (devolucion != null) devolucion.procesarDevolucion("");
        try {
            pago.procesarReembolso();
        } catch (Devolucion.ReembolsoException e) {
            Log.log("Pedido", "No se pudo realizar el reembolso");
        }

    }

    private BigDecimal calcularTotalProductos() {
        return productos.stream()
                .map(Producto::getPrecio)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public String infoPedido() {
        return String.format(
                "Pedido: %s | Envío: %s | Fecha de Entrega: %s | Pago: %s",
                id,
                seguimiento.getEstado(),
                fechaEntrega,
                pago.getEstado()
        );
    }

    public void iniciarDevolucion(String motivo) {
        this.devolucion = new Devolucion(pago);
        devolucion.procesarDevolucion(motivo);
        seguimiento.cancelarEnvio();
    }
}