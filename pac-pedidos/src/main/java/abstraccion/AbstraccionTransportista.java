package abstraccion;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

interface AbstraccionTransportista {
    BigDecimal calcularTarifaBase(String direccion, List<Producto> productos);
    LocalDate getFechaBaseEntrega(String direccion);
}
