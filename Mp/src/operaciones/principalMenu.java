package operaciones;

import principal.EstadoJuego;
import usuario.Usuario;

import java.io.IOException;
import java.util.Scanner;

public class principalMenu extends MenuPrincipalOperaciones {

    public principalMenu (EstadoJuego estado, Usuario usuario){
        super(estado, usuario);



    }

    @Override
    protected void initializeList() {
        operationList.add(new SignUp(estado, usuario));
        operationList.add(new LogIn(estado,usuario));
    }

    @Override
    public void doOperation() throws IOException, ClassNotFoundException {
        System.out.println();
        System.out.println();
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        if (str.equalsIgnoreCase("s")){
            System.out.println();
        } else {
        }
    }



    }