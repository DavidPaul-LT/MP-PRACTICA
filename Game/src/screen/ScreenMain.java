package screen;


import screen.General.Screen;
import screen.General.ScreenSignUp;

import java.util.Scanner;

public class ScreenMain extends Screen {
    private int option;
    Scanner scanner = new Scanner(System.in);

    public ScreenMain(String title) {
        super(title);
        this.loadOptions();
    }

    @Override
    public void getOption(){
        this.option = scanner.nextInt();
        switch (option) {
            case 1:
                new ScreenSignUp("Registrarse");
                break;
            case 2:
                new ScreenLogin("Inicar sesión");
                break;
            case 3:
                new DeleteAccountScreen("Borrar cuenta");
                break;
            case 4:
                break;
            default:
                this.addSpacing();
                this.loadOptions();
        }
    }

    @Override
    public void loadOptions() {
        System.out.println("Registrarse [1]");
        System.out.println("Iniciar sesión [2]");
        System.out.println("Borrar cuenta [3]");
        System.out.println("Salir de la app [4]");
        System.out.println("EXIT []");
        this.getOption();
    }
}