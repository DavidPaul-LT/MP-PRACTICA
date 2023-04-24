package ScreenClass;

import java.util.Scanner;

public class ScreenMain extends Screen{
    private int option;
    Scanner scanner = new Scanner(System.in);
    public ScreenMain(String title) {
        super(title);

    }
    public void showOptions(){
        System.out.println("Bienvenido a Noche de batallas: el juego de rol multijugador");
        System.out.println("Deleta account [0]");
        System.out.println("SingUp [1]");
        System.out.println("LogIn [2]");
        System.out.println("EXIT []3");
        this.option = scanner.nextInt();
        switch (option){
            case 1:
                Screen logIn = new ScreenLogin("Login");
                break;
            case 2:
                Screen signUp = new ScreenSingUp("SignUp");
        }
    }

}
