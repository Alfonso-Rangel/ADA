package abstraccion;

class EmailAdapter implements CorreoInterface {
    private APIEmail apiEmail;
    private String remitente;
    private String apiKey;

    public EmailAdapter(APIEmail apiEmail, String remitente, String apiKey) {
        this.apiEmail = apiEmail;
        this.remitente = remitente;
        this.apiKey = apiKey;
    }

    @Override
    public boolean enviar(String destinatario, String asunto, String contenido) {
        boolean autorizado = apiEmail.autorizarEnvio(apiKey, remitente, destinatario);

        if (autorizado) {
            return apiEmail.procesarEmail(remitente, destinatario, asunto, contenido, "HTML");
        } else {
            System.out.println("Envío no autorizado a " + destinatario);
            return false;
        }
    }
}
