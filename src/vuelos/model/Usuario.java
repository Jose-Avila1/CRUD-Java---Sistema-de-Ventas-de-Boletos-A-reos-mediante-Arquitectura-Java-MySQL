package vuelos.model;

public class Usuario {
    
    public static int idUsuarioLogueado;
    
    // 1. Atributos privados (Encapsulamiento)
    private String nombre;
    private String apellido;
    private String cedula;
    private String telefono;
    private String correo;
    private String contrasena;

    // 3. Constructor con todos los parámetros (Para crear el usuario rápido al registrarse)
    public Usuario(String nombre, String apellido, String cedula, String telefono, String correo, String contrasena) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.telefono = telefono;
        this.correo = correo;
        this.contrasena = contrasena;
    }

    // 4. Métodos Getters y Setters (Para acceder a los datos de forma segura)
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getCedula() { return cedula; }
    public void setCedula(String cedula) { this.cedula = cedula; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getContrasena() { return contrasena; }
    public void setContrasena(String contrasena) { this.contrasena = contrasena; }
}
    

