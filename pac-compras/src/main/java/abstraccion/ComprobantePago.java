package abstraccion;

import java.time.LocalDateTime;

public class ComprobantePago {
    float monto;
    String estado;  // "Éxito" o "Fallido"
    String mensaje; // Mensaje para mostrar al usuario
    LocalDateTime fecha;

    // Constructor
    public ComprobantePago(float monto, String estado, String mensaje) {
        this.monto = monto;
        this.estado = estado;
        this.mensaje = mensaje;
        this.fecha = LocalDateTime.now();  // Se registra la fecha y hora actual
    }

    // Método que define cómo se imprimirá el comprobante
    @Override
    public String toString() {
        return "ComprobantePago {" +
                "Monto: $" + monto +
                ", Estado: '" + estado + '\'' +
                ", Mensaje: '" + mensaje + '\'' +
                ", Fecha: " + fecha +
                '}';
    }
}