package principal;

import operaciones.principalMenu;
import usuario.Usuario;

import java.io.IOException;

public class Juego {

    public void start() throws IOException, ClassNotFoundException {
        principalMenu menuPrincipal = new principalMenu( new EstadoJuego(), new Usuario() );
        principalMenu.doOperation();
    }
}
