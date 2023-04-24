package ScreenClass;

import java.util.Scanner;

public class ScreenMain extends Screen{
    private int option;
    Scanner scanner = new Scanner(System.in);
    public ScreenMain(String title) {
        super(title);

        showOptions();
        getOptions();
    }


    @Override
    public void getOptions() {

    }

    public void showOptions(){
        System.out.println("Bienvenido a Noche de batallas: el juego de rol multijugador");
        System.out.println("Registrarse [1]");
        System.out.println("Entrar [2]");
        System.out.println("Eliminar Cuenta [3]");
        System.out.println("Salir [4]");
        System.out.println("Administrar Cuenta [5]");
        System.out.print("Seleccion: ");
        this.option = scanner.nextInt();
        switch (option){
            case 1:
                Screen signUp = new ScreenSingUp("SignUp");
                showOptions();
                break;
            case 2:
                Screen logIn = new ScreenLogin("Login");
                break;
            case 3:
                //TODO clase Screen Delete Account
                showOptions();
            case 4:
                System.exit(0);
            case 5:
                Screen AccountAdmin = new ScreenBanOrUnban("Administrar Cuenta");
                break;
            default:
                showOptions();
        }
    }

}
