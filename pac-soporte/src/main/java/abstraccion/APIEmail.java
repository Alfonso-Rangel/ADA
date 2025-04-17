package abstraccion;

class APIEmail {

    public boolean autorizarEnvio(String apiKey, String remitente, String destinatario) {
        System.out.println("Autorizando envío desde " + remitente + " hacia " + destinatario);
        // Ponemos un ejemplo en donde bloqueamos el envío
        return !destinatario.equals("blocked@example.com");
    }

    public boolean procesarEmail(String remitente, String destinatario, String asunto, String contenido, String formato) {
        System.out.println("API Email: Enviando email con formato " + formato);
        System.out.println("  De: " + remitente);
        System.out.println("  Para: " + destinatario);
        System.out.println("  Asunto: " + asunto);

        try {
            Thread.sleep(500);
            return true;
        } catch (InterruptedException e) {
            System.err.println("Error al enviar email: " + e.getMessage());
            return false;
        }
    }
}
