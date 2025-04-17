package abstraccion;

class Mensajeria {
    private CorreoInterface correoService;

    public Mensajeria(CorreoInterface correoService) {
        this.correoService = correoService;
    }

    public boolean enviarCorreo(Mensaje mensaje) {
        System.out.println("Mensajería: Procesando mensaje...");
        return correoService.enviar(
                mensaje.getDestinatario(),
                mensaje.getAsunto(),
                mensaje.getContenido()
        );
    }
}