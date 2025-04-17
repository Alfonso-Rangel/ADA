package abstraccion;

import java.math.BigDecimal;

class ImplementacionNacional implements AbstraccionTipoEnvio {
    @Override
    public BigDecimal getMultiplicadorCosto() {
        return new BigDecimal("1.0");
    }

    @Override
    public int getDiasAdicionales() {
        return 0;
    }
}