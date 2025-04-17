package abstraccion;

class Mensaje {
    private String remitente;
    private String destinatario;
    private String contenido;
    private String asunto;

    public Mensaje(String remitente, String destinatario, String asunto, String contenido) {
        this.remitente = remitente;
        this.destinatario = destinatario;
        this.asunto = asunto;
        this.contenido = contenido;
    }

    public String getRemitente() {
        return remitente;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public String getContenido() {
        return contenido;
    }

    public String getAsunto() {
        return asunto;
    }
}
