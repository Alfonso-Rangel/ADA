package abstraccion.builder;

public class DirectorUsuario {
    private UsuarioBuilder builder;

    public void setUsuarioBuilder(UsuarioBuilder builder) {
        this.builder = builder;
    }

    public Usuario construirUsuario() {
        builder.construirPerfil();
        builder.configurarPermisos();
        return builder.getUsuario();
    }
}
