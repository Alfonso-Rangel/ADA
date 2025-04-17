package abstraccion;

class SeguimientoEnvio {
    private EstadoEnvio estadoActual;
    private String ubicacion;

    protected SeguimientoEnvio() {
        this.estadoActual = EstadoEnvio.EN_PREPARACION;
        this.ubicacion = "Almacén Central";
        Log.log("pedido", "Seguimiento", "Nuevo seguimiento para pedido");
    }

    protected void actualizarEstado() {
        estadoActual = estadoActual.procesar(this);
    }

    protected void cancelarEnvio() {
        estadoActual = estadoActual.cancelar(this);
    }

    protected String getEstado() {
        return estadoActual.getDescripcion() + " | Ubicación: " + ubicacion;
    }

    protected enum EstadoEnvio {
        EN_PREPARACION {
            @Override
            EstadoEnvio procesar(SeguimientoEnvio seguimiento) {
                seguimiento.ubicacion = "En tránsito";
                return EN_CAMINO;
            }

            @Override
            EstadoEnvio cancelar(SeguimientoEnvio seguimiento) {
                seguimiento.ubicacion = "Cancelado";
                return CANCELADO;
            }

            @Override
            String getDescripcion() {
                return "En preparación";
            }
        },
        EN_CAMINO {
            @Override
            EstadoEnvio procesar(SeguimientoEnvio seguimiento) {
                seguimiento.ubicacion = "Destino final";
                return ENTREGADO;
            }

            @Override
            EstadoEnvio cancelar(SeguimientoEnvio seguimiento) {
                seguimiento.ubicacion = "Pedido Cancelado";
                return CANCELADO;
            }

            @Override
            String getDescripcion() {
                return "En camino";
            }
        },
        ENTREGADO {
            @Override
            EstadoEnvio procesar(SeguimientoEnvio seguimiento) {
                throw new IllegalStateException("El envío ya fue entregado");
            }

            @Override
            EstadoEnvio cancelar(SeguimientoEnvio seguimiento) {
                throw new IllegalStateException("El envío ya fue entregado");
            }

            @Override
            String getDescripcion() {
                return "Entregado";
            }
        },
        CANCELADO {
            @Override
            EstadoEnvio procesar(SeguimientoEnvio seguimiento) {
                throw new IllegalStateException("Envío cancelado");
            }

            @Override
            EstadoEnvio cancelar(SeguimientoEnvio seguimiento) {
                throw new IllegalStateException("El envío ya está cancelado");
            }

            @Override
            String getDescripcion() {
                return "Cancelado";
            }
        };

        abstract EstadoEnvio procesar(SeguimientoEnvio seguimiento);
        abstract EstadoEnvio cancelar(SeguimientoEnvio seguimiento);
        abstract String getDescripcion();
    }
}
