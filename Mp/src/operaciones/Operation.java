package operaciones;

import principal.EstadoJuego;
import usuario.Usuario;

import java.io.FileNotFoundException;
import java.io.IOException;

public abstract class Operation {

    protected EstadoJuego estado;

    protected Usuario usuario;


    public Operation (EstadoJuego estado, Usuario usuario){

        this.estado = estado;

        this.usuario = usuario;


    }

    public abstract void doOperation () throws IOException, FileNotFoundException, ClassNotFoundException;

}
