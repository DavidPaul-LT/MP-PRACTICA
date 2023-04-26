package operaciones;

import principal.EstadoJuego;
import usuario.Usuario;

import java.io.FileNotFoundException;
import java.io.IOException;

public class SignUp extends Operation {
    public SignUp(EstadoJuego estado, Usuario usuario) {
        super(estado, usuario);
    }

    @Override
    public void doOperation() throws IOException, FileNotFoundException, ClassNotFoundException {

    }
}
