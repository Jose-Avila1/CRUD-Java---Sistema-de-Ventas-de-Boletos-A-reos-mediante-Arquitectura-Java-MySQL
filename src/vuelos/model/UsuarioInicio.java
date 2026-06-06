package vuelos.model;


public class UsuarioInicio {
    
    private String correo;
    private String password;
    
    public UsuarioInicio(String correo,String Password){
    
        this.correo = correo;
        this.password = Password;
    
    }
    
    public String getCorreo(){return this.correo;}
    public String getPassword(){return this.password;}
}
