package abstraccion;

class Devolucion {
    protected enum EstadoDevolucion {EN_PROCESO, APROBADA, RECHAZADA, COMPLETADA}

    private final Reembolsable medioReembolso;
    private String motivo;

    protected Devolucion(Reembolsable medioReembolso) {
        this.medioReembolso = medioReembolso;
    }

    protected void procesarDevolucion(String motivo) {
        Log.log("pedido", "devolucion", "Procesando devolucion...");
        validarMotivo(motivo);
        actualizarEstado(EstadoDevolucion.APROBADA, motivo);
        Log.log("devolucion", "Devolución aprobada, iniciando reembolso...");
        try {
            medioReembolso.procesarReembolso();
            actualizarEstado(EstadoDevolucion.COMPLETADA, null);
        } catch (ReembolsoException e) {
            actualizarEstado(EstadoDevolucion.RECHAZADA, e.getMessage());
        }
    }

    private void validarMotivo(String motivo) {
        if (motivo == null || motivo.isBlank()) {
            throw new IllegalArgumentException("Motivo requerido para devolución");
        }
    }

    private void actualizarEstado(EstadoDevolucion nuevoEstado, String mensaje) {
        this.motivo = (mensaje != null) ? mensaje : this.motivo;
    }

    public interface Reembolsable {
        void procesarReembolso() throws ReembolsoException;
    }

    public static class ReembolsoException extends Exception {
        public ReembolsoException(String mensaje) {
            super(mensaje);
        }
    }
}