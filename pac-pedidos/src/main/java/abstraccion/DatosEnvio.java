package abstraccion;

class DatosEnvio {
    private String direccion;
    private final ValidadorDireccion validador = new ValidadorDireccion();

    protected void obtenerDireccion() {
        Log.log("pedido", "DatosEnvio", "Obteniendo dirección del usuario...");
        capturaDireccion();
        validarDireccion();
    }

    private void capturaDireccion() {
        this.direccion = "Cuajimalpa de Morelos, CDMX";
    }

    private void validarDireccion() {
        if (!validador.esValida(direccion)) {
            Log.log("DatosEnvio", "Dirección no válida: " + direccion);
            throw new RuntimeException(direccion);
        }
        Log.log("DatosEnvio", "Dirección validada: " + direccion);
    }

    protected String getDireccion() {return direccion;}

    // Implementación básica para prototipo, pero esto lo hace la API.
    protected static class ValidadorDireccion {
        public boolean esValida(String direccion) {
            return direccion != null && !direccion.trim().isEmpty();
        }
    }
}