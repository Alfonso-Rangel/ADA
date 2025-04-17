package abstraccion.builder;

public class VendedorBuilder implements UsuarioBuilder {
    private Usuario usuario;

    public VendedorBuilder() {
        this.usuario = new Usuario("Javier", "Martínez", "javier@vendedor.com", "2025-04-04");
    }

    public void construirPerfil() {
        usuario.setRol("Vendedor");
    }

    public void configurarPermisos() {
        // Configurar permisos específicos de Vendedor
    }

    public Usuario getUsuario() {
        return usuario;
    }
}
