package abstraccion;

import java.math.BigDecimal;

class ImplementacionInternacional implements AbstraccionTipoEnvio {
    @Override
    public BigDecimal getMultiplicadorCosto() {
        return new BigDecimal("2.5");
    }

    @Override
    public int getDiasAdicionales() {
        return 3;
    }
}
