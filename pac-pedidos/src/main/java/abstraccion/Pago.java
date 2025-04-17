package abstraccion;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Pago implements Devolucion.Reembolsable {
    public enum EstadoPago {PENDIENTE, PROCESANDO, COMPLETADO, RECHAZADO, REEMBOLSADO, CANCELADO}

    private MetodoPago metodoPago;
    private EstadoPago estado = EstadoPago.PENDIENTE;

    public String procesarPago(BigDecimal monto, List<Producto> productos) {
        Log.log("Pedido", "Pago", "Capturando Método de Pago...");
        capturarMetodoPago();
        try {
            validarPago(monto);
            estado = EstadoPago.COMPLETADO;
            Log.log("Pago", "Pago exitoso");
        } catch (Exception e) {
            estado = EstadoPago.RECHAZADO;
            return e.getMessage();
        }
        return FacturaGenerator.generar(metodoPago, productos);
    }

    public EstadoPago getEstado() {
        return estado;
    }

    // Interfaz para métodos de pago
    public interface MetodoPago {
        String getTitular();
        String getMascaraNumero();
        String getFechaExpiracion();
    }

    // Implementación para Visa
    public static class Visa implements MetodoPago {
        private final String numero;
        private final String titular;
        private final String expiracion;

        public Visa(String numero, String titular, String expiracion) {
            this.numero = numero;
            this.titular = titular;
            this.expiracion = expiracion;
        }

        @Override
        public String getTitular() {
            return titular;
        }

        @Override
        public String getMascaraNumero() {
            return "****-" + numero.substring(12);
        }

        @Override
        public String getFechaExpiracion() {
            return expiracion.split("/")[0] + "/20" + expiracion.split("/")[1];
        }

        @Override
        public String toString() {
            return String.format("TIPO: Visa, TITULAR: %s, NUM: %s, EXP: %s", this.titular, this.numero, this.expiracion);
        }
    }

    private void validarPago(BigDecimal monto) {
        if (monto.compareTo(BigDecimal.ZERO) <= 0) {
            throw new RuntimeException("Monto inválido: " + monto);
        }
        // Lógica de validación del método de pago iría aquí
    }

    @Override
    public void procesarReembolso() throws Devolucion.ReembolsoException {
        if (estado != EstadoPago.COMPLETADO) {
            throw new Devolucion.ReembolsoException("Reembolso no permitido en estado: " + estado);
        }
        // Lógica de reembolso iría aquí
        estado = EstadoPago.REEMBOLSADO;
        Log.log("Pago", "Reembolso completado");
    }

    private void capturarMetodoPago() {
        this.metodoPago = new Visa(
                "4242424242424242",
                "Luis Alfonso Rangel Olvera",
                "12/28"
        );
        Log.log("Pago", "Método de pago capturado: " + metodoPago);
    }

    private static class FacturaGenerator {
        public static String generar(Pago.MetodoPago metodo, List<Producto> productos) {
            // Cálculos (sin cambios)
            BigDecimal subtotal = calculaSubtotal(productos);
            BigDecimal iva = calculaIva(subtotal);
            BigDecimal totalFactura = subtotal.add(iva);

            // Construcción de items
            StringBuilder itemsFactura = new StringBuilder();
            productos.forEach(p -> itemsFactura.append(
                    String.format("| %-15s |     1 | %5.2f | %6.2f |%n",
                            p.getNombre(),
                            p.getPrecio(),
                            p.getPrecio())
            ));

            // Formateo de datos
            String tarjetaMascara = metodo.getMascaraNumero();
            String expiracion = metodo.getFechaExpiracion();
            String titular = metodo.getTitular();

            return String.format("""
        ==========================================
                          FACTURA         \s
        ==========================================
        Cliente: Luis Alfonso Rangel Olvera               \s
        NIF: 12345678A                         \s
        Dirección: Calle Falsa, 10, 3ºB        \s
                 05600- Cuajimalpa de Morelos   \s
        ==========================================
        Nº Factura: F-2025-0001                \s
        Fecha: %s                      \s
        ==========================================
        | Concepto         | Cant. | P.U.  | Total |
        ==========================================
        %s
        ==========================================
                              Subtotal: %6.2f $
                               IVA 12%%:  %6.2f $
                                 TOTAL: %6.2f $
        ==========================================
        Forma de pago: Visa (%s)
        Titular: %s
        Expiración: %s          \s
        ==========================================
                ¡Gracias por su compra!             \s
        ==========================================
       \s""",
                    LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                    itemsFactura,
                    subtotal,
                    iva,
                    totalFactura,
                    tarjetaMascara,
                    titular,
                    expiracion
            );
        }

        private static BigDecimal calculaSubtotal(List<Producto> productos) {
            return productos.stream()
                    .map(Producto::getPrecio)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
        }

        private static BigDecimal calculaIva(BigDecimal subtotal) {
            return subtotal.multiply(new BigDecimal("0.12"))
                    .setScale(2, RoundingMode.HALF_UP);
        }
    }
}