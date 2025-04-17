package abstraccion.builder;

public class CompradorBuilder implements UsuarioBuilder {
    private Usuario usuario;

    public CompradorBuilder() {
        this.usuario = new Usuario("Ana", "López", "ana@comprador.com", "2025-04-04");
    }

    public void construirPerfil() {
        usuario.setRol("Comprador");
    }

    public void configurarPermisos() {
        // Configurar permisos específicos de Comprador
    }

    public Usuario getUsuario() {
        return usuario;
    }
}
