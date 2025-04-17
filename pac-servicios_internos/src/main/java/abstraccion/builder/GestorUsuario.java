package abstraccion.builder;

public class GestorUsuario {
    public static void main(String[] args) {
        DirectorUsuario director = new DirectorUsuario();
        Registro registro = new Registro();

        // Crear Administrador
        UsuarioBuilder adminBuilder = new AdministradorBuilder();
        director.setUsuarioBuilder(adminBuilder);
        Usuario admin = director.construirUsuario();
        registro.registrarUsuario(admin);

        // Crear Comprador
        UsuarioBuilder compradorBuilder = new CompradorBuilder();
        director.setUsuarioBuilder(compradorBuilder);
        Usuario comprador = director.construirUsuario();
        registro.registrarUsuario(comprador);

        // Crear Vendedor
        UsuarioBuilder vendedorBuilder = new VendedorBuilder();
        director.setUsuarioBuilder(vendedorBuilder);
        Usuario vendedor = director.construirUsuario();
        registro.registrarUsuario(vendedor);
    }
}
