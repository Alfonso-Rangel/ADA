package abstraccion.builder;

public class AdministradorBuilder implements UsuarioBuilder {
    private Usuario usuario;

    public AdministradorBuilder() {
        this.usuario = new Usuario("Carlos", "Ramírez", "carlos@admin.com", "2025-04-04");
    }

    public void construirPerfil() {
        usuario.setRol("Administrador");
    }

    public void configurarPermisos() {
        // Configurar permisos específicos de Administrador si se desea
    }

    public Usuario getUsuario() {
        return usuario;
    }
}
