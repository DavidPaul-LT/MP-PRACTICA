package principal;

import operaciones.principalMenu;
import usuario.Usuario;

public class Juego {

    public void start() {
        principalMenu menuPrincipal = new principalMenu(new EstadoJuego(), new Usuario());
        principalMenu.operaciones();
    }
}
