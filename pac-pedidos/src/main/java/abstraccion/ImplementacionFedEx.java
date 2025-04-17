package abstraccion;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

class ImplementacionFedEx implements AbstraccionTransportista {
    @Override
    public BigDecimal calcularTarifaBase(String direccion, List<Producto> productos) {
        return new BigDecimal("150.00");
    }

    @Override
    public LocalDate getFechaBaseEntrega(String direccion) {
        return LocalDate.now().plusDays(3);
    }
}
