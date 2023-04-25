package usuario;

import java.io.Serializable;

public class Usuario implements Serializable {

    protected String apodo;
    protected String nombreUsuario;

    protected String contrasena;

    public Usuario(){


    }
    public Usuario(String nombreUsuario, String contrasena, String apodo){

        this.nombreUsuario = nombreUsuario;

        this.contrasena = contrasena;

        this.apodo = apodo;

    }

    public String getApodo(){
        return apodo;

    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombreUsuario(){
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
}
