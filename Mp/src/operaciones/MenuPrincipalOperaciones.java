package operaciones;

import principal.EstadoJuego;
import usuario.Usuario;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public abstract class MenuPrincipalOperaciones extends Operation{

    protected ArrayList<Operation> listaOperaciones = new ArrayList<>();


    public MenuPrincipalOperaciones (EstadoJuego estado, Usuario usuario){

        super(estado,usuario);
        initializeList();



    }

    protected abstract void initializeList();

    @Override
    public void doOperation() throws IOException, ClassNotFoundException {

    }
}
