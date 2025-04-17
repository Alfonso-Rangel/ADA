package abstraccion.builder;

public class Usuario {
    private String nombre;
    private String apellido;
    private String correo;
    private String contrasena;
    private String direccion;
    private String telefono;
    private String rol;
    private String fechaRegistro;

    public Usuario(String nombre, String apellido, String correo, String fechaRegistro) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.fechaRegistro = fechaRegistro;
    }

    // Setters
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getCorreo() {
        return correo;
    }

    @Override
    public String toString() {
        return "Usuario creado -> Nombre: " + nombre + ", Apellido: " + apellido +
                ", Correo: " + correo + ", Rol: " + rol + ", Fecha Registro: " + fechaRegistro;
    }
}
