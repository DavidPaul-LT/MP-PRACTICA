package operaciones;

import principal.EstadoJuego;
import usuario.Usuario;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Jugar extends Operation{

    private MenuPrincipalOperaciones operacionMenuPrincipal;

    public Jugar (EstadoJuego estadoJuego, Usuario usuario){

        super(estadoJuego, usuario);


    }

    public void setOperacionMenuPrincipal(MenuPrincipalOperaciones operacionMenuPrincipal){

        this.operacionMenuPrincipal = operacionMenuPrincipal;

    }

    @Override
    public void doOperation() throws IOException, FileNotFoundException, ClassNotFoundException {

        operacionMenuPrincipal.doOperation();

    }


}
