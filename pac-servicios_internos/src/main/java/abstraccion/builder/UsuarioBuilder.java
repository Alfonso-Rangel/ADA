package abstraccion.builder;

public interface UsuarioBuilder {
    void construirPerfil();

    void configurarPermisos();

    Usuario getUsuario();
}
