package abstraccion;

import java.math.BigDecimal;

class ImplementacionExpress implements AbstraccionTipoEnvio {
    @Override
    public BigDecimal getMultiplicadorCosto() {
        return new BigDecimal("1.8");
    }

    @Override
    public int getDiasAdicionales() {
        return -2;
    }
}