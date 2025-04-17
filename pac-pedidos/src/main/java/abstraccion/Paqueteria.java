package abstraccion;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;

class Paqueteria {
    private final AbstraccionTransportista transportista;
    private final AbstraccionTipoEnvio tipoEnvio;

    protected Paqueteria(AbstraccionTransportista transportista, AbstraccionTipoEnvio tipoEnvio) {
        this.transportista = transportista;
        this.tipoEnvio = tipoEnvio;
        Log.log("pedido", "Paqueteria", "Envio configurado: " + transportista.getClass().getSimpleName()
                + " + " + tipoEnvio.getClass().getSimpleName());
    }

    protected BigDecimal calcularTarifa(String direccion, List<Producto> productos) {
        BigDecimal base = transportista.calcularTarifaBase(direccion, productos);
        BigDecimal multiplicador = tipoEnvio.getMultiplicadorCosto();
        return base.multiply(multiplicador).setScale(2, RoundingMode.HALF_UP);
    }

    protected LocalDate calcularFechaEntrega(String direccion) {
        LocalDate fechaBase = transportista.getFechaBaseEntrega(direccion);
        return fechaBase.plusDays(tipoEnvio.getDiasAdicionales());
    }
}