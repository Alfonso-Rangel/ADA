package abstraccion.builder;

import java.util.HashMap;
import java.util.Map;

public class Registro {
    private Map<String, Usuario> usuarios = new HashMap<>();

    public void registrarUsuario(Usuario usuario) {
        usuarios.put(usuario.getCorreo(), usuario);
        System.out.println("Usuario registrado: " + usuario);
    }
}
